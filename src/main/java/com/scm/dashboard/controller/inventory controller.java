
package com.scm.dashboard.controller;

import com.scm.dashboard.model.Inventory;
import com.scm.dashboard.service.AlertService;
import com.scm.dashboard.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {
    
    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private AlertService alertService;
    
    @PostMapping("/update")
    public ResponseEntity<Inventory> updateStock(@RequestBody Map<String, Object> request) {
        String productName = (String) request.get("productName");
        Integer stockLevel = Integer.valueOf(request.get("stockLevel").toString());
        String platform = (String) request.getOrDefault("platform", "Zoho");
        
        Inventory inventory = inventoryService.updateStock(productName, stockLevel, platform);
        
        // Create alert for low stock
        if (stockLevel < 100) {
            alertService.createSystemAlert(
                "Low stock alert: " + productName + " (" + stockLevel + " units)", platform);
        }
        
        return ResponseEntity.ok(inventory);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }
    
    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<Inventory>> getInventoryByPlatform(@PathVariable String platform) {
        return ResponseEntity.ok(inventoryService.getInventoryByPlatform(platform));
    }
    
    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getInventoryMetrics() {
        return ResponseEntity.ok(Map.of(
            "totalItems", inventoryService.getAllInventory().size(),
            "lowStockAlerts", inventoryService.getLowStockCount(),
            "totalStock", inventoryService.getTotalStock()
        ));
    }
    
    @PostMapping("/alert")
    public ResponseEntity<Map<String, String>> createStockAlert(@RequestBody Map<String, Object> request) {
        Integer threshold = Integer.valueOf(request.get("threshold").toString());
        String alertType = (String) request.get("alertType");
        String platform = (String) request.getOrDefault("platform", "Zoho");
        
        String alertId = "AL-" + (100 + (int)(Math.random() * 900));
        
        alertService.createSystemAlert(
            alertType + " alert set with threshold " + threshold, platform);
        
        return ResponseEntity.ok(Map.of(
            "alertId", alertId,
            "message", "Alert created successfully"
        ));
    }
}
