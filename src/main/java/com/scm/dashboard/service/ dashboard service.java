
package com.scm.dashboard.service;

import com.scm.dashboard.model.DashboardMetrics;
import com.scm.dashboard.repository.DashboardMetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class DashboardService {
    
    @Autowired
    private DashboardMetricsRepository metricsRepository;
    
    private final Random random = new Random();
    
    public DashboardMetrics getCurrentMetrics() {
        DashboardMetrics latest = metricsRepository.findLatestMetrics();
        if (latest == null) {
            latest = initializeDefaultMetrics();
        }
        return latest;
    }
    
    public DashboardMetrics updateMetrics(DashboardMetrics metrics) {
        metrics.setLastUpdated(LocalDateTime.now());
        return metricsRepository.save(metrics);
    }
    
    public DashboardMetrics addOrder(Double orderAmount) {
        DashboardMetrics current = getCurrentMetrics();
        current.setTotalOrders(current.getTotalOrders() + 1);
        current.setInventoryValue(current.getInventoryValue() + orderAmount);
        return updateMetrics(current);
    }
    
    public DashboardMetrics simulateRealTimeUpdate() {
        DashboardMetrics current = getCurrentMetrics();
        
        // Small random variations
        current.setTotalOrders(current.getTotalOrders() + random.nextInt(3));
        current.setActiveShipments(current.getActiveShipments() + random.nextInt(5) - 2);
        current.setSupplierPerformance(Math.max(75.0, 
            Math.min(100.0, current.getSupplierPerformance() + (random.nextDouble() - 0.5) * 5)));
        
        return updateMetrics(current);
    }
    
    private DashboardMetrics initializeDefaultMetrics() {
        DashboardMetrics metrics = new DashboardMetrics(
            1247, // Total Orders
            2500000.0, // Inventory Value
            156, // Active Shipments
            89.5 // Supplier Performance
        );
        return metricsRepository.save(metrics);
    }
}
