package com.scm.dashboard.config;

import com.scm.dashboard.service.AlertService;
import com.scm.dashboard.service.InventoryService;
import com.scm.dashboard.service.PurchaseOrderService;
import com.scm.dashboard.service.APICSSCORService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private APICSSCORService apicsSCORService;

    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data
        purchaseOrderService.initializeSampleData();
        inventoryService.initializeSampleData();
        alertService.initializeSampleData();
        apicsSCORService.initializeAPICSData();

        System.out.println("Sample data initialized successfully!");
    }
}