
package com.scm.dashboard.service;

import com.scm.dashboard.model.Inventory;
import com.scm.dashboard.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    private final Random random = new Random();
    
    public Inventory updateStock(String productName, Integer stockLevel, String platform) {
        Optional<Inventory> existing = inventoryRepository.findByProductNameAndPlatform(productName, platform);
        
        Inventory inventory;
        if (existing.isPresent()) {
            inventory = existing.get();
            inventory.setStockLevel(stockLevel);
        } else {
            inventory = new Inventory(productName, stockLevel, platform);
        }
        
        return inventoryRepository.save(inventory);
    }
    
    public List<Inventory> getInventoryByPlatform(String platform) {
        return inventoryRepository.findByPlatform(platform);
    }
    
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    
    public Long getLowStockCount() {
        return inventoryRepository.countByStatus("Low");
    }
    
    public Long getTotalStock() {
        Long total = inventoryRepository.getTotalStock();
        return total != null ? total : 0L;
    }
    
    public void initializeSampleData() {
        if (inventoryRepository.count() == 0) {
            String[] products = {"Widget A", "Component B", "Part C", "Module D", "Assembly E"};
            String[] platforms = {"Zoho", "SAP", "Oracle"};
            
            for (String product : products) {
                for (String platform : platforms) {
                    Integer stock = 50 + random.nextInt(400);
                    inventoryRepository.save(new Inventory(product, stock, platform));
                }
            }
        }
    }
}
