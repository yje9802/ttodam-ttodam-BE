package com.ttodampartners.ttodamttodam.domain.notification.repository;

import com.ttodampartners.ttodamttodam.domain.notification.entity.NotificationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
  List<NotificationEntity> findAllByUserId(Long userId);
}
