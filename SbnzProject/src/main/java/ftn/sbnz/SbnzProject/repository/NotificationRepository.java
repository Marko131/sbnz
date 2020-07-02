package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Notification;
import ftn.sbnz.SbnzProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    Notification findFirstByDateAndUserOrderByIdDesc(Date date, User user);
}
