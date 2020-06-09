package ftn.sbnz.SbnzProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Meal> meals;

    @Temporal(TemporalType.DATE)
    Date date;


    @ManyToOne
    User user;

    public Day() {
    }

    public Day(User user) {
        this.meals = new ArrayList<Meal>();
        this.user = user;
        this.date = new Date();
    }

    public Day(List<Meal> meals, Date date, User user) {
        this.meals = meals;
        this.date = date;
        this.user = user;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
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
