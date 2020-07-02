package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Activity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UpdateProfileDTO {

    @NotNull(message = "Age is required")
    @Min(value = 15, message = "Please provide number between 15 and 80")
    @Max(value = 80, message = "Please provide number between 15 and 80")
    private Integer age;
    @NotNull(message = "Height is required")
    @Positive(message = "Please provide positive number")
    private Double height;
    @NotNull(message = "Weight is required")
    @Positive(message = "Please provide positive number")
    private Double weight;
    @NotNull(message = "Activity is required")
    private Activity activity;

    public UpdateProfileDTO() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
