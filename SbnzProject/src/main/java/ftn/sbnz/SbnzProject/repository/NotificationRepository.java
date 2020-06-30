package ftn.sbnz.SbnzProject.repository;

import ftn.sbnz.SbnzProject.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
