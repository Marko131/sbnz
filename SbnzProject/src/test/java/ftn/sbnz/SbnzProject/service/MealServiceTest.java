package ftn.sbnz.SbnzProject.service;

import ftn.sbnz.SbnzProject.exceptions.NotFoundException;
import ftn.sbnz.SbnzProject.model.*;
import ftn.sbnz.SbnzProject.repository.DayRepository;
import ftn.sbnz.SbnzProject.repository.MealRecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MealServiceTest {

    @Autowired
    private MealService mealService;

    @MockBean
    private DayRepository dayRepository;

    @Autowired
    private UserDayService userDayService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MealRecipeRepository mealRecipeRepository;

    @Test
    public void testAddMeal(){
        User testUser = new User();
        Day testDay = new Day(testUser);
        Mockito.when(dayRepository.findByDateAndUser(any(Date.class), any(User.class))).thenReturn(testDay);
        Mockito.when(dayRepository.save(testDay)).thenReturn(testDay);

        Food steak = new Food("Steak", 100, 1, 2, 3);
        Ingredient ingredient = new Ingredient(steak, 300);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        mealService.addMeal(ingredients, testUser, MealEnum.LUNCH);
        assertEquals(1, testDay.getMeals().size());
    }

    @Test
    public void testNotifications() {
        User u = userDetailsService.findUserByEmail("markostanic@gmail.com");
        Notification notification = userDayService.getNotification(u);
        System.out.println(notification);
    }

    @Test
    public void testEvent() throws InterruptedException {
        User u = userDetailsService.findUserByEmail("markostanic@gmail.com");
        MealRecipe mealRecipe = mealRecipeRepository.findById(1).orElseThrow(()-> new NotFoundException("Not found"));
        userDayService.testEvent(mealRecipe, u);

    }
}
