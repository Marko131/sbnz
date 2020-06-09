package ftn.sbnz.SbnzProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private Food food;

    @Column(nullable = false)
    private double gram;

    public Ingredient() {
    }

    public Ingredient(Food food, double gram) {
        this.food = food;
        this.gram = gram;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", food=" + food +
                ", gram=" + gram +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id.equals(that.id);
    }

}
