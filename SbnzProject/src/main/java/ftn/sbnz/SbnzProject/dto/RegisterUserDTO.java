package ftn.sbnz.SbnzProject.dto;

import ftn.sbnz.SbnzProject.model.Activity;
import ftn.sbnz.SbnzProject.model.Gender;

import javax.validation.constraints.*;

public class RegisterUserDTO {

    @Email(message = "Required valid email")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password1;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password2;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Age is required")
    @Min(value = 15, message = "Please provide an age between 15 and 80")
    @Max(value = 80, message = "Please provide an age between 15 and 80")
    private Integer age;

    @NotNull(message = "Gender is required")
    private Gender gender;


    @NotNull(message = "Height is required")
    @Positive(message = "Height must be positive number")
    private Double height;

    @NotNull(message = "Weight is required")
    private Double weight;

    @NotNull(message = "Activity is required")
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
