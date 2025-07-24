
package com.scm.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "stock_level")
    private Integer stockLevel;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "platform")
    private String platform;
    
    @Column(name = "last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;
    
    // Constructors
    public Inventory() {
        this.lastUpdated = LocalDateTime.now();
    }
    
    public Inventory(String productName, Integer stockLevel, String platform) {
        this.productName = productName;
        this.stockLevel = stockLevel;
        this.platform = platform;
        this.lastUpdated = LocalDateTime.now();
        this.status = calculateStatus(stockLevel);
    }
    
    private String calculateStatus(Integer stock) {
        if (stock < 100) return "Low";
        if (stock > 300) return "High";
        return "Normal";
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public Integer getStockLevel() { return stockLevel; }
    public void setStockLevel(Integer stockLevel) { 
        this.stockLevel = stockLevel;
        this.status = calculateStatus(stockLevel);
        this.lastUpdated = LocalDateTime.now();
    }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
