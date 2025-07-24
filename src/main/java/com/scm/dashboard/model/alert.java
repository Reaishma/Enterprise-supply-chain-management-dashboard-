
package com.scm.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "message", length = 500)
    private String message;
    
    @Column(name = "alert_type")
    private String alertType;
    
    @Column(name = "platform")
    private String platform;
    
    @Column(name = "priority")
    private String priority;
    
    @Column(name = "is_read")
    private Boolean isRead;
    
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    
    // Constructors
    public Alert() {
        this.createdDate = LocalDateTime.now();
        this.isRead = false;
        this.priority = "Medium";
    }
    
    public Alert(String message, String alertType, String platform) {
        this.message = message;
        this.alertType = alertType;
        this.platform = platform;
        this.createdDate = LocalDateTime.now();
        this.isRead = false;
        this.priority = "Medium";
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    
    public Boolean getIsRead() { return isRead; }
    public void setIsRead(Boolean isRead) { this.isRead = isRead; }
    
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}
