package ftn.sbnz.SbnzProject.service;

import ftn.sbnz.SbnzProject.exceptions.NotFoundException;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.repository.MealRecipeRepository;
import ftn.sbnz.SbnzProject.repository.NotificationRepository;
import ftn.sbnz.SbnzProject.repository.UserDayRepository;
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

    public MealRecipe addMeal(Integer mealID, User user){
        UserDay userDay = userDayRepository.findByDateAndUser(new Date(), user);
        if (userDay == null) userDay = new UserDay(user);

        MealRecipe mealRecipe = mealRecipeRepository.findById(mealID).orElseThrow(() -> new NotFoundException("Meal not found"));
        userDay.getMealRecipes().add(mealRecipe);

        userDayRepository.save(userDay);

        return mealRecipe;
        /*
        ArrayList<Message> messages = new ArrayList<>();
        KieSession kieSession = kieContainer.newKieSession("meal-session");
        kieSession.getAgenda().getAgendaGroup("meal").setFocus();
        d.getMeals().forEach(kieSession::insert);
        kieSession.insert(messages);
        kieSession.fireAllRules();

        messages = distinct(messages);
        messages.forEach(System.out::println);
        */
        //List<Message> messages1 = checkMeal(m);
        //messages1.forEach(System.out::println);
    }

    public UserDay getDay(User user) {
        UserDay userDay = userDayRepository.findByDateAndUser(new Date(), user);
        if (userDay == null) userDay = new UserDay(user);

        Notification notification = new Notification();

        KieSession kieSession = kieContainer.newKieSession("day-session");
        kieSession.getAgenda().getAgendaGroup("day-rules").setFocus();
        kieSession.insert(userDay);

        kieSession.insert(notification);

        int rules = kieSession.fireAllRules();

        notification.text.forEach(System.out::println);
        System.out.println("Notifications: " + notification.getText().size());

        System.out.println("Number of rules for day: " + rules);
        return userDay;

    }

    public List<MealRecipe> searchMeals(String name) {
        return mealRecipeRepository.findAllByNameContains(name);
    }
}
