package ftn.sbnz.SbnzProject.controller;

import ftn.sbnz.SbnzProject.dto.AddMealDTO;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.service.UserDayService;
import ftn.sbnz.SbnzProject.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserDayController {

    @Autowired
    private UserDayService userDayService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/day/meal/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MealRecipe> postMeal(@PathVariable Integer id){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);

        MealRecipe mealRecipe = userDayService.addMeal(id, user);

        return new ResponseEntity<>(mealRecipe, HttpStatus.OK);
    }

    @GetMapping("/day/meal")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDay> getDay(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);

        UserDay userDay = userDayService.getDay(user);
        return new ResponseEntity<>(userDay, HttpStatus.OK);
    }

    @GetMapping("/day/meal/search/{value}")
    public ResponseEntity<List<MealRecipe>> searchMeals(@PathVariable("value") String name){
        if (name == null) name = "";
        List<MealRecipe> mealRecipes = userDayService.searchMeals(name);
        return new ResponseEntity<>(mealRecipes, HttpStatus.OK);
    }

    @GetMapping("/notification")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Notification> getNotification(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);
        Notification notification = userDayService.getNotification(user);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

}
