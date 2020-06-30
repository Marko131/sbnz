package ftn.sbnz.SbnzProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class UserDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    @ManyToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<MealRecipe> mealRecipes;

    @Temporal(TemporalType.DATE)
    Date date;


    @ManyToOne
    User user;

    public UserDay() {
    }

    public UserDay(User user){
        this.mealRecipes = new ArrayList<>();
        this.date = new Date();
        this.user = user;
    }

    public UserDay(List<MealRecipe> mealRecipes, Date date, User user) {
        this.mealRecipes = mealRecipes;
        this.date = date;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MealRecipe> getMealRecipes() {
        return mealRecipes;
    }

    public void setMealRecipes(List<MealRecipe> mealRecipes) {
        this.mealRecipes = mealRecipes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
