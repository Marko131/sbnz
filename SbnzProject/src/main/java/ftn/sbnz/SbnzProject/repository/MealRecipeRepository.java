package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Meal;
import ftn.sbnz.SbnzProject.model.MealRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRecipeRepository extends JpaRepository<MealRecipe, Integer> {

    List<MealRecipe> findAllByNameContains(String name);
}
