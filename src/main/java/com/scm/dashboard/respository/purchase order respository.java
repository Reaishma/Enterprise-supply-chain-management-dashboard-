
package com.scm.dashboard.repository;

import com.scm.dashboard.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    
    List<PurchaseOrder> findByPlatformOrderByCreatedDateDesc(String platform);
    
    @Query("SELECT COUNT(p) FROM PurchaseOrder p WHERE p.platform = :platform")
    Long countByPlatform(@Param("platform") String platform);
    
    @Query("SELECT p FROM PurchaseOrder p ORDER BY p.createdDate DESC LIMIT 10")
    List<PurchaseOrder> findRecentPurchaseOrders();
}
