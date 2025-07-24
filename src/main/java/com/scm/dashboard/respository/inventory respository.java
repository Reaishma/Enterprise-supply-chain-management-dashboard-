
package com.scm.dashboard.repository;

import com.scm.dashboard.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
    Optional<Inventory> findByProductNameAndPlatform(String productName, String platform);
    
    List<Inventory> findByPlatform(String platform);
    
    @Query("SELECT COUNT(i) FROM Inventory i WHERE i.status = :status")
    Long countByStatus(@Param("status") String status);
    
    @Query("SELECT SUM(i.stockLevel) FROM Inventory i")
    Long getTotalStock();
}
