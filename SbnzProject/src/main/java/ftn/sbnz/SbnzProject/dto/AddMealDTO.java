package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Ingredient;
import ftn.sbnz.SbnzProject.model.MealEnum;

import java.util.List;

public class AddMealDTO {

    private List<IngredientDTO> ingredients;

    private MealEnum mealEnum;

    public AddMealDTO() {
    }

    public AddMealDTO(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public MealEnum getMealEnum() {
        return mealEnum;
    }

    public void setMealEnum(MealEnum mealEnum) {
        this.mealEnum = mealEnum;
    }
}
