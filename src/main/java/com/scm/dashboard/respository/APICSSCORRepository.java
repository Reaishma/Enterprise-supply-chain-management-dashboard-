
package com.scm.dashboard.repository;

import com.scm.dashboard.model.APICSSCORModel;
import com.scm.dashboard.model.APICSSCORModel.SCORProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface APICSSCORRepository extends JpaRepository<APICSSCORModel, Long> {
    
    Optional<APICSSCORModel> findByProcess(SCORProcess process);
    
    List<APICSSCORModel> findByPerformanceScoreGreaterThan(Double score);
    
    List<APICSSCORModel> findByPerformanceScoreLessThan(Double score);
    
    @Query("SELECT s FROM APICSSCORModel s ORDER BY s.performanceScore DESC")
    List<APICSSCORModel> findAllOrderByPerformanceScoreDesc();
    
    @Query("SELECT AVG(s.performanceScore) FROM APICSSCORModel s")
    Double getAveragePerformanceScore();
    
    @Query("SELECT s FROM APICSSCORModel s WHERE s.performanceScore < 70.0")
    List<APICSSCORModel> findProcessesNeedingImprovement();
}
