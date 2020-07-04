package ftn.sbnz.SbnzProject.service;

import ftn.sbnz.SbnzProject.exceptions.NotFoundException;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.repository.MealRecipeRepository;
import ftn.sbnz.SbnzProject.repository.NotificationRepository;
import ftn.sbnz.SbnzProject.repository.UserDayRepository;
import org.aspectj.weaver.ast.Not;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserDayService {

    @Autowired
    private MealRecipeRepository mealRecipeRepository;

    @Autowired
    private UserDayRepository userDayRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SessionService sessionService;

    public MealRecipe addMeal(Integer mealID, User user){
        UserDay userDay = userDayRepository.findByDateAndUser(new Date(), user);
        if (userDay == null) userDay = new UserDay(user);

        MealRecipe mealRecipe = mealRecipeRepository.findById(mealID).orElseThrow(() -> new NotFoundException("Meal not found"));
        userDay.getMealRecipes().add(mealRecipe);
        userDayRepository.save(userDay);

        Notification notification = new Notification(user);
        KieSession kieSession = kieContainer.newKieSession("day-session");
        kieSession.getAgenda().getAgendaGroup("day-rules").setFocus();
        kieSession.insert(userDay);
        kieSession.insert(notification);

        Notification notification1 = checkMeal(userDay, notification);

        kieSession.fireAllRules();
        notificationRepository.save(notification1);

        testEvent(mealRecipe, user);

        return mealRecipe;
    }

    private Notification checkMeal(UserDay userDay, Notification notification) {
        KieSession kieSession = kieContainer.newKieSession("meal-session");
        kieSession.getAgenda().getAgendaGroup("query").setFocus();
        userDay.getMealRecipes().forEach(kieSession::insert);
        kieSession.insert(notification);
        kieSession.fireAllRules();
        return notification;
    }

    public UserDay getDay(User user) {
        UserDay userDay = userDayRepository.findByDateAndUser(new Date(), user);
        if (userDay == null) userDay = new UserDay(user);
        getEvent(user);
        return userDay;

    }

    public List<MealRecipe> searchMeals(String name) {
        List<MealRecipe> mealRecipes = mealRecipeRepository.findAllByNameContains(name);
        List<MealRecipe> sorted = sortMealRecipes(mealRecipes);
        return sorted;
    }

    public Notification getNotification(User user) {
        getEvent(user);
        return notificationRepository.findFirstByDateAndUserOrderByIdDesc(new Date(), user);

    }

    public void testEvent(MealRecipe mealRecipe, User user)  {
        KieSession kieSession = sessionService.getKieSession();
        kieSession.insert(mealRecipe);
        kieSession.insert(user);
        kieSession.fireAllRules();
    }

    public void getEvent(User user){
        KieSession kieSession = sessionService.getKieSession();
        kieSession.insert(user);
        Notification notification = notificationRepository.findFirstByDateAndUserOrderByIdDesc(new Date(), user);
        if (notification == null)
            notification = new Notification(user);
        kieSession.insert(notification);
        kieSession.fireAllRules();
        notification.text.forEach(System.out::println);
        notificationRepository.save(notification);
    }

    private List<MealRecipe> sortMealRecipes(List<MealRecipe> mealRecipes){
        KieSession kieSession = kieContainer.newKieSession("meal-session");
        kieSession.getAgenda().getAgendaGroup("sort").setFocus();
        mealRecipes.forEach(kieSession::insert);
        Meals meals = new Meals();
        kieSession.insert(meals);
        kieSession.fireAllRules();
        return meals.getMealRecipeArrayList();
    }
}
