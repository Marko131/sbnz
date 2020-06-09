package ftn.sbnz.SbnzProject.service;

import antlr.debug.MessageAdapter;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.repository.DayRepository;
import ftn.sbnz.SbnzProject.repository.UserRepository;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.*;


@Service
public class MealService {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SessionService sessionService;

    public void addMeal(List<Ingredient> ingredients, User user, MealEnum mealEnum){
        Day day = dayRepository.findByDateAndUser(new Date(), user);
        if (day == null) day = new Day(user);
        Meal m = new Meal(ingredients, mealEnum);
        day.getMeals().add(m);
        Day d = dayRepository.save(day);

        ArrayList<Message> messages = new ArrayList<>();
        KieSession kieSession = kieContainer.newKieSession("meal-session");
        kieSession.getAgenda().getAgendaGroup("meal").setFocus();
        d.getMeals().forEach(kieSession::insert);
        kieSession.insert(messages);
        kieSession.fireAllRules();

        messages = distinct(messages);
        messages.forEach(System.out::println);

        List<Message> messages1 = checkMeal(m);
        messages1.forEach(System.out::println);
    }

    public Day getDay(User user) {
        KieSession kieSession = kieContainer.newKieSession("meal-session");
        Day day = dayRepository.findByDateAndUser(new Date(), user);
        if (day == null) day = new Day(user);
        day.getMeals().forEach(kieSession::insert);
        System.out.println("Number of meals: " + day.getMeals().size());
        int rules = kieSession.fireAllRules();
        System.out.println("Number of rules" + rules);

        QueryResults results = kieSession.getQueryResults( "people over the age of 30" );
        System.out.println( "we have " + results.size() + " people over the age  of 30" );

        System.out.println( "These people are are over 30:" );

        for ( QueryResultsRow row : results ) {
            Meal meal = ( Meal ) row.get( "$meal" );
            System.out.println( meal.getMealEnum() + "\n" );
        }

        return day;
    }

    public List<Message> checkMeal(Meal meal){
        List<Message> messages = new ArrayList<>();

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("check-meal").setFocus();
        kieSession.insert(meal);
        kieSession.insert(messages);
        kieSession.fireAllRules();
        return messages;
    }


    public void testRules(){

        KieSession kSession = sessionService.getKieSession();
        kSession.getAgenda().getAgendaGroup("meal").setFocus();
        User user = userRepository.findByEmail("markostanic222@gmail.com");

        Day day = dayRepository.findByDateAndUser(new Date(), user);
        if (day == null) return;
        day.getMeals().forEach(kSession::insert);

        kSession.fireAllRules();
    }

    private ArrayList<Message> distinct(ArrayList<Message> messages){
        ArrayList<Message> filter = new ArrayList<>();
        messages.forEach(message -> {
            boolean contains = false;
            for (Message m: filter) {
                if (m.getText().equals(message.getText())) {
                    contains = true;
                    break;
                }
            }
            if (!contains) filter.add(message);
        });
        return filter;
    }

}
