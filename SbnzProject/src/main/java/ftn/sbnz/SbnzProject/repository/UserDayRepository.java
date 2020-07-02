package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Day;
import ftn.sbnz.SbnzProject.model.User;
import ftn.sbnz.SbnzProject.model.UserDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserDayRepository extends JpaRepository<UserDay, Integer> {

    UserDay findByDateAndUser(Date date, User user);
}
