package ftn.sbnz.SbnzProject.model;

import java.util.ArrayList;

public class Meals {

    ArrayList<MealRecipe> mealRecipeArrayList;

    public Meals() {
        this.mealRecipeArrayList = new ArrayList<>();
    }

    public Meals(ArrayList<MealRecipe> mealRecipeArrayList) {
        this.mealRecipeArrayList = mealRecipeArrayList;
    }

    public ArrayList<MealRecipe> getMealRecipeArrayList() {
        return mealRecipeArrayList;
    }

    public void setMealRecipeArrayList(ArrayList<MealRecipe> mealRecipeArrayList) {
        this.mealRecipeArrayList = mealRecipeArrayList;
    }

    public void addMeal(MealRecipe mealRecipe) {
        this.mealRecipeArrayList.add(mealRecipe);
    }
}
