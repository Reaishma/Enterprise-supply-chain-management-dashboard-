
package com.scm.dashboard.service;

import com.scm.dashboard.model.PurchaseOrder;
import com.scm.dashboard.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    
    private final Random random = new Random();
    
    public PurchaseOrder createPurchaseOrder(String supplier, Double amount, String platform) {
        String poNumber = generatePONumber();
        PurchaseOrder po = new PurchaseOrder(poNumber, supplier, amount, platform);
        return purchaseOrderRepository.save(po);
    }
    
    public List<PurchaseOrder> getPurchaseOrdersByPlatform(String platform) {
        return purchaseOrderRepository.findByPlatformOrderByCreatedDateDesc(platform);
    }
    
    public List<PurchaseOrder> getRecentPurchaseOrders() {
        return purchaseOrderRepository.findRecentPurchaseOrders();
    }
    
    public Long getCountByPlatform(String platform) {
        return purchaseOrderRepository.countByPlatform(platform);
    }
    
    public PurchaseOrder updateStatus(Long id, String status) {
        PurchaseOrder po = purchaseOrderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Purchase Order not found"));
        po.setStatus(status);
        return purchaseOrderRepository.save(po);
    }
    
    private String generatePONumber() {
        return "PO-" + (1000 + random.nextInt(9000));
    }
    
    public void initializeSampleData() {
        if (purchaseOrderRepository.count() == 0) {
            String[] suppliers = {"Acme Corp", "Global Supply", "TechParts Inc", "Industrial Co"};
            String[] platforms = {"SAP", "Oracle", "Dynamics365"};
            String[] statuses = {"Pending", "Approved", "Shipped", "Delivered"};
            
            for (int i = 0; i < 15; i++) {
                String supplier = suppliers[random.nextInt(suppliers.length)];
                String platform = platforms[random.nextInt(platforms.length)];
                String status = statuses[random.nextInt(statuses.length)];
                Double amount = 5000 + random.nextDouble() * 45000;
                
                PurchaseOrder po = createPurchaseOrder(supplier, amount, platform);
                po.setStatus(status);
                purchaseOrderRepository.save(po);
            }
        }
    }
}
