
package com.scm.dashboard.repository;

import com.scm.dashboard.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    
    @Query("SELECT a FROM Alert a ORDER BY a.createdDate DESC LIMIT :limit")
    List<Alert> findRecentAlerts(@Param("limit") int limit);
    
    List<Alert> findByPlatformOrderByCreatedDateDesc(String platform);
    
    @Query("SELECT COUNT(a) FROM Alert a WHERE a.isRead = false")
    Long countUnreadAlerts();
    
    List<Alert> findByIsReadFalseOrderByCreatedDateDesc();
}
