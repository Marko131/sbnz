package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Day;
import ftn.sbnz.SbnzProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DayRepository extends JpaRepository<Day, Integer> {

    Day findByDateAndUser(Date date, User user);
}
