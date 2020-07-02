package ftn.sbnz.SbnzProject.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.kie.api.definition.type.Position;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class MealRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private MealEnum mealEnum;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> ingredients;

    @Column
    private String description;

    @Column
    private double calories;

    @Column
    private double protein;

    @Column
    private double fat;

    @Column
    private double carbohydrates;

    @Column
    @Position(0)
    private double sugars;

    @Column
    @Position(1)
    private double saturatedFat;


    public MealRecipe() {
    }

    public MealRecipe(String name, MealEnum mealEnum, List<String> ingredients, String description, double calories, double protein, double fat, double carbohydrates, double sugars, double saturatedFat) {
        this.name = name;
        this.mealEnum = mealEnum;
        this.ingredients = ingredients;
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.saturatedFat = saturatedFat;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MealRecipe{" +
                "id=" + id +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", sugars=" + sugars +
                ", saturatedFat=" + saturatedFat +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealEnum getMealEnum() {
        return mealEnum;
    }

    public void setMealEnum(MealEnum mealEnum) {
        this.mealEnum = mealEnum;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }
}
