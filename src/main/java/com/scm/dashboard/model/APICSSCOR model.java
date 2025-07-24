
package com.scm.dashboard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "apics_scor_model")
public class APICSSCORModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private SCORProcess process;
    
    private String processDescription;
    private String metrics;
    private Double performanceScore;
    private String bestPractices;
    private String improvementAreas;
    private LocalDateTime lastUpdated;
    
    // APICS Performance Metrics
    private Double orderFulfillmentRate;
    private Double supplyChainCosts;
    private Integer cashToCashCycleTime;
    private Double assetTurns;
    private Double upwardFlexibility;
    private Double downwardAdaptability;
    
    public enum SCORProcess {
        PLAN("Strategic Planning & Demand Management"),
        SOURCE("Supplier Relationship & Procurement"),
        MAKE("Manufacturing & Production"),
        DELIVER("Order Management & Logistics"),
        RETURN("Returns & Reverse Logistics");
        
        private final String description;
        
        SCORProcess(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    // Constructors
    public APICSSCORModel() {}
    
    public APICSSCORModel(SCORProcess process, String processDescription, Double performanceScore) {
        this.process = process;
        this.processDescription = processDescription;
        this.performanceScore = performanceScore;
        this.lastUpdated = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public SCORProcess getProcess() { return process; }
    public void setProcess(SCORProcess process) { this.process = process; }
    
    public String getProcessDescription() { return processDescription; }
    public void setProcessDescription(String processDescription) { this.processDescription = processDescription; }
    
    public String getMetrics() { return metrics; }
    public void setMetrics(String metrics) { this.metrics = metrics; }
    
    public Double getPerformanceScore() { return performanceScore; }
    public void setPerformanceScore(Double performanceScore) { this.performanceScore = performanceScore; }
    
    public String getBestPractices() { return bestPractices; }
    public void setBestPractices(String bestPractices) { this.bestPractices = bestPractices; }
    
    public String getImprovementAreas() { return improvementAreas; }
    public void setImprovementAreas(String improvementAreas) { this.improvementAreas = improvementAreas; }
    
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
    
    public Double getOrderFulfillmentRate() { return orderFulfillmentRate; }
    public void setOrderFulfillmentRate(Double orderFulfillmentRate) { this.orderFulfillmentRate = orderFulfillmentRate; }
    
    public Double getSupplyChainCosts() { return supplyChainCosts; }
    public void setSupplyChainCosts(Double supplyChainCosts) { this.supplyChainCosts = supplyChainCosts; }
    
    public Integer getCashToCashCycleTime() { return cashToCashCycleTime; }
    public void setCashToCashCycleTime(Integer cashToCashCycleTime) { this.cashToCashCycleTime = cashToCashCycleTime; }
    
    public Double getAssetTurns() { return assetTurns; }
    public void setAssetTurns(Double assetTurns) { this.assetTurns = assetTurns; }
    
    public Double getUpwardFlexibility() { return upwardFlexibility; }
    public void setUpwardFlexibility(Double upwardFlexibility) { this.upwardFlexibility = upwardFlexibility; }
    
    public Double getDownwardAdaptability() { return downwardAdaptability; }
    public void setDownwardAdaptability(Double downwardAdaptability) { this.downwardAdaptability = downwardAdaptability; }
}
