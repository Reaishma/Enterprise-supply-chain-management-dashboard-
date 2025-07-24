
package com.scm.dashboard.controller;

import com.scm.dashboard.model.Alert;
import com.scm.dashboard.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
public class AlertController {
    
    @Autowired
    private AlertService alertService;
    
    @GetMapping("/recent")
    public ResponseEntity<List<Alert>> getRecentAlerts(@RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(alertService.getRecentAlerts(limit));
    }
    
    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<Alert>> getAlertsByPlatform(@PathVariable String platform) {
        return ResponseEntity.ok(alertService.getAlertsByPlatform(platform));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Alert> createAlert(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        String alertType = request.getOrDefault("alertType", "User");
        String platform = request.getOrDefault("platform", "System");
        
        Alert alert = alertService.createAlert(message, alertType, platform);
        return ResponseEntity.ok(alert);
    }
    
    @PostMapping("/{id}/read")
    public ResponseEntity<Alert> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.markAsRead(id));
    }
    
    @GetMapping("/count/unread")
    public ResponseEntity<Map<String, Long>> getUnreadCount() {
        return ResponseEntity.ok(Map.of("unreadCount", alertService.getUnreadCount()));
    }
}
