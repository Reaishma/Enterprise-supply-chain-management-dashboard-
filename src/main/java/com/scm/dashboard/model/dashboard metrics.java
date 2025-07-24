
package com.scm.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dashboard_metrics")
public class DashboardMetrics {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "total_orders")
    private Integer totalOrders;
    
    @Column(name = "inventory_value")
    private Double inventoryValue;
    
    @Column(name = "active_shipments")
    private Integer activeShipments;
    
    @Column(name = "supplier_performance")
    private Double supplierPerformance;
    
    @Column(name = "last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;
    
    // Constructors
    public DashboardMetrics() {
        this.lastUpdated = LocalDateTime.now();
    }
    
    public DashboardMetrics(Integer totalOrders, Double inventoryValue, 
                           Integer activeShipments, Double supplierPerformance) {
        this.totalOrders = totalOrders;
        this.inventoryValue = inventoryValue;
        this.activeShipments = activeShipments;
        this.supplierPerformance = supplierPerformance;
        this.lastUpdated = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Integer getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Integer totalOrders) { this.totalOrders = totalOrders; }
    
    public Double getInventoryValue() { return inventoryValue; }
    public void setInventoryValue(Double inventoryValue) { this.inventoryValue = inventoryValue; }
    
    public Integer getActiveShipments() { return activeShipments; }
    public void setActiveShipments(Integer activeShipments) { this.activeShipments = activeShipments; }
    
    public Double getSupplierPerformance() { return supplierPerformance; }
    public void setSupplierPerformance(Double supplierPerformance) { this.supplierPerformance = supplierPerformance; }
    
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
