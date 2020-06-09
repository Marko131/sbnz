package ftn.sbnz.SbnzProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Table
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Ingredient> ingredients;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(nullable = false)
    private MealEnum mealEnum;

    public Meal() {
    }

    public Meal(Integer id, List<Ingredient> ingredients, Date timestamp) {
        this.id = id;
        this.ingredients = ingredients;
        this.timestamp = timestamp;
    }

    public Meal(List<Ingredient> ingredients, MealEnum mealEnum) {
        this.ingredients = ingredients;
        this.timestamp = new Date();
        this.mealEnum = mealEnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public MealEnum getMealEnum() {
        return mealEnum;
    }

    public void setMealEnum(MealEnum mealEnum) {
        this.mealEnum = mealEnum;
    }
}
