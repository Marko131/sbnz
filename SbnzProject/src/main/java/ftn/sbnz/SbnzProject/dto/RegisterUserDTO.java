package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Activity;
import ftn.sbnz.SbnzProject.model.Gender;

public class RegisterUserDTO {

    private String email;
    private String password1;
    private String password2;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double height;
    private double weight;
    private Activity activity;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String email, String password1, String password2, String firstName, String lastName, int age, Gender gender, double height, double weight, Activity activity) {
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
