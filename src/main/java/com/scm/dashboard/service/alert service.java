
package com.scm.dashboard.service;

import com.scm.dashboard.model.Alert;
import com.scm.dashboard.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    
    @Autowired
    private AlertRepository alertRepository;
    
    public Alert createAlert(String message, String alertType, String platform) {
        Alert alert = new Alert(message, alertType, platform);
        return alertRepository.save(alert);
    }
    
    public List<Alert> getRecentAlerts(int limit) {
        return alertRepository.findRecentAlerts(limit);
    }
    
    public List<Alert> getAlertsByPlatform(String platform) {
        return alertRepository.findByPlatformOrderByCreatedDateDesc(platform);
    }
    
    public Long getUnreadCount() {
        return alertRepository.countUnreadAlerts();
    }
    
    public Alert markAsRead(Long id) {
        Alert alert = alertRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setIsRead(true);
        return alertRepository.save(alert);
    }
    
    public void createSystemAlert(String message, String platform) {
        createAlert(message, "System", platform);
    }
    
    public void createUserAlert(String message, String platform) {
        createAlert(message, "User", platform);
    }
    
    public void initializeSampleData() {
        if (alertRepository.count() == 0) {
            String[] messages = {
                "Supplier Alpha Industries - Delivery delay expected",
                "Warehouse NY-01 - Capacity approaching 95%",
                "Route optimization completed - 12% cost savings",
                "Demand forecast updated for Widget A",
                "Low stock alert for Component B"
            };
            
            String[] platforms = {"SAP", "Oracle", "Dynamics365", "BlueYonder", "Zoho"};
            
            for (int i = 0; i < messages.length; i++) {
                createAlert(messages[i], "System", platforms[i % platforms.length]);
            }
        }
    }
}
