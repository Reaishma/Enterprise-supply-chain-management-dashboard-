
package com.scm.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SupplyChainDashboardApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SupplyChainDashboardApplication.class, args);
    }
}
