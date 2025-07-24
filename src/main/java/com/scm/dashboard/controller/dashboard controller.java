
package com.scm.dashboard.controller;

import com.scm.dashboard.model.DashboardMetrics;
import com.scm.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;
    
    @GetMapping("/metrics")
    public ResponseEntity<DashboardMetrics> getCurrentMetrics() {
        return ResponseEntity.ok(dashboardService.getCurrentMetrics());
    }
    
    @PostMapping("/metrics/update")
    public ResponseEntity<DashboardMetrics> updateMetrics(@RequestBody DashboardMetrics metrics) {
        return ResponseEntity.ok(dashboardService.updateMetrics(metrics));
    }
    
    @PostMapping("/order/add")
    public ResponseEntity<DashboardMetrics> addOrder(@RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return ResponseEntity.ok(dashboardService.addOrder(amount));
    }
    
    @PostMapping("/simulate")
    public ResponseEntity<DashboardMetrics> simulateUpdate() {
        return ResponseEntity.ok(dashboardService.simulateRealTimeUpdate());
    }
}
