package ftn.sbnz.SbnzProject.controller;

import ftn.sbnz.SbnzProject.dto.AddMealDTO;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.repository.DayRepository;
import ftn.sbnz.SbnzProject.repository.MealRepository;
import ftn.sbnz.SbnzProject.repository.UserRepository;
import ftn.sbnz.SbnzProject.service.MealService;
import ftn.sbnz.SbnzProject.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("meal")
public class MealController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MealService mealService;

    @GetMapping("/test")
    public String test(){
        mealService.testRules();
        return "OK";
    }

    @GetMapping("/day")
    @PreAuthorize("hasRole('USER')")
    public Day getDay(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);

        return mealService.getDay(user);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> postMeal(@RequestBody AddMealDTO meal){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);

        List<Ingredient> ingredients = new ArrayList<>();
        meal.getIngredients().forEach(ingredientDTO -> ingredients.add(new Ingredient(ingredientDTO.getFood(), ingredientDTO.getGram())));

        mealService.addMeal(ingredients, user, meal.getMealEnum());

        return new ResponseEntity<>("Meal successfully added", HttpStatus.OK);
    }


}
