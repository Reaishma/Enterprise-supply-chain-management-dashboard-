
package com.scm.dashboard.repository;

import com.scm.dashboard.model.DashboardMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardMetricsRepository extends JpaRepository<DashboardMetrics, Long> {
    
    @Query("SELECT d FROM DashboardMetrics d ORDER BY d.lastUpdated DESC LIMIT 1")
    DashboardMetrics findLatestMetrics();
}
