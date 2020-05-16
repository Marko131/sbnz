package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Activity;
import ftn.sbnz.SbnzProject.model.Gender;

public class UserProfileDTO {

    private String email;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double height;
    private double weight;
    private double bmi;
    private String bodyStatus;
    private double bmr;
    private double calories;
    private Activity activity;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String email, String firstName, String lastName, int age, Gender gender, double height, double weight, double bmi, String bodyStatus, double bmr, double calories, Activity activity) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bodyStatus = bodyStatus;
        this.bmr = bmr;
        this.calories = calories;
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getBodyStatus() {
        return bodyStatus;
    }

    public void setBodyStatus(String bodyStatus) {
        this.bodyStatus = bodyStatus;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
