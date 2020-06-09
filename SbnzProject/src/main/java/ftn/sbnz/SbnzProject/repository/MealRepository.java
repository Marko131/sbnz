package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
