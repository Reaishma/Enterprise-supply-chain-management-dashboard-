
package com.scm.dashboard.controller;

import com.scm.dashboard.model.PurchaseOrder;
import com.scm.dashboard.service.AlertService;
import com.scm.dashboard.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sap")
@CrossOrigin(origins = "*")
public class SAPController {
    
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    
    @Autowired
    private AlertService alertService;
    
    @PostMapping("/purchase-order")
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody Map<String, Object> request) {
        String supplier = (String) request.get("supplier");
        Double amount = Double.valueOf(request.get("amount").toString());
        
        PurchaseOrder po = purchaseOrderService.createPurchaseOrder(supplier, amount, "SAP");
        
        // Create alert
        alertService.createSystemAlert(
            "SAP: New PO " + po.getPoNumber() + " created for " + supplier, "SAP");
        
        return ResponseEntity.ok(po);
    }
    
    @PostMapping("/planning-cycle")
    public ResponseEntity<Map<String, Object>> startPlanningCycle(@RequestBody Map<String, String> request) {
        String planningType = request.get("planningType");
        String cycleId = "PC-" + (100 + (int)(Math.random() * 900));
        
        alertService.createSystemAlert(
            "SAP: " + planningType + " cycle " + cycleId + " started", "SAP");
        
        return ResponseEntity.ok(Map.of(
            "cycleId", cycleId,
            "planningType", planningType,
            "status", "Started",
            "estimatedDuration", (2 + (int)(Math.random() * 4)) + " hours"
        ));
    }
    
    @GetMapping("/purchase-orders")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrders() {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrdersByPlatform("SAP"));
    }
    
    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getSAPMetrics() {
        Long totalPOs = purchaseOrderService.getCountByPlatform("SAP");
        return ResponseEntity.ok(Map.of(
            "activePOs", totalPOs,
            "planningCycles", 3 + (int)(Math.random() * 8),
            "systemStatus", "Online"
        ));
    }
}
