package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Food;

public class IngredientDTO {

    private Food food;
    private double gram;

    public IngredientDTO() {
    }

    public IngredientDTO(Food food, double gram) {
        this.food = food;
        this.gram = gram;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getGram() {
        return gram;
    }

    public void setGram(double gram) {
        this.gram = gram;
    }
}
