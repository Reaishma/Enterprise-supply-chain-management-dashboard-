
package com.scm.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "po_number", unique = true)
    private String poNumber;
    
    @Column(name = "supplier")
    private String supplier;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "platform")
    private String platform;
    
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    
    // Constructors
    public PurchaseOrder() {
        this.createdDate = LocalDateTime.now();
        this.status = "Pending";
    }
    
    public PurchaseOrder(String poNumber, String supplier, Double amount, String platform) {
        this.poNumber = poNumber;
        this.supplier = supplier;
        this.amount = amount;
        this.platform = platform;
        this.createdDate = LocalDateTime.now();
        this.status = "Pending";
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}
