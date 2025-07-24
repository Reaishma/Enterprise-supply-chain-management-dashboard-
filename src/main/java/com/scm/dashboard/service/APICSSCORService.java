
package com.scm.dashboard.service;

import com.scm.dashboard.model.APICSSCORModel;
import com.scm.dashboard.model.APICSSCORModel.SCORProcess;
import com.scm.dashboard.repository.APICSSCORRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

@Service
public class APICSSCORService {
    
    @Autowired
    private APICSSCORRepository apicsSCORRepository;
    
    private final Random random = new Random();
    
    public List<APICSSCORModel> getAllSCORProcesses() {
        return apicsSCORRepository.findAll();
    }
    
    public APICSSCORModel getSCORProcessById(Long id) {
        return apicsSCORRepository.findById(id).orElse(null);
    }
    
    public APICSSCORModel getSCORProcessByType(SCORProcess process) {
        return apicsSCORRepository.findByProcess(process).orElse(null);
    }
    
    public APICSSCORModel createSCORProcess(APICSSCORModel scorModel) {
        scorModel.setLastUpdated(LocalDateTime.now());
        return apicsSCORRepository.save(scorModel);
    }
    
    public APICSSCORModel updateSCORProcess(APICSSCORModel scorModel) {
        scorModel.setLastUpdated(LocalDateTime.now());
        return apicsSCORRepository.save(scorModel);
    }
    
    public void deleteSCORProcess(Long id) {
        apicsSCORRepository.deleteById(id);
    }
    
    public Map<String, Object> getAPICSDashboardMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        
        // Overall SCOR Performance
        Double avgPerformance = apicsSCORRepository.getAveragePerformanceScore();
        metrics.put("averagePerformance", avgPerformance != null ? avgPerformance : 0.0);
        
        // Process-specific metrics
        List<APICSSCORModel> allProcesses = apicsSCORRepository.findAllOrderByPerformanceScoreDesc();
        metrics.put("topPerformingProcess", allProcesses.isEmpty() ? "N/A" : allProcesses.get(0).getProcess().name());
        
        // Areas needing improvement
        List<APICSSCORModel> improvementAreas = apicsSCORRepository.findProcessesNeedingImprovement();
        metrics.put("processesNeedingImprovement", improvementAreas.size());
        
        // APICS Key Performance Indicators
        metrics.put("orderFulfillmentRate", calculateAverageOrderFulfillment());
        metrics.put("supplyChainCosts", calculateAverageSupplyChainCosts());
        metrics.put("cashToCashCycle", calculateAverageCashToCashCycle());
        metrics.put("assetTurns", calculateAverageAssetTurns());
        metrics.put("flexibility", calculateAverageFlexibility());
        
        return metrics;
    }
    
    public void initializeAPICSData() {
        // Initialize SCOR processes if they don't exist
        for (SCORProcess process : SCORProcess.values()) {
            if (!apicsSCORRepository.findByProcess(process).isPresent()) {
                APICSSCORModel scorModel = new APICSSCORModel();
                scorModel.setProcess(process);
                scorModel.setProcessDescription(process.getDescription());
                scorModel.setPerformanceScore(75.0 + random.nextDouble() * 20.0); // 75-95% performance
                
                // Set realistic APICS metrics
                scorModel.setOrderFulfillmentRate(85.0 + random.nextDouble() * 10.0);
                scorModel.setSupplyChainCosts(10.0 + random.nextDouble() * 5.0);
                scorModel.setCashToCashCycleTime(30 + random.nextInt(60));
                scorModel.setAssetTurns(3.0 + random.nextDouble() * 2.0);
                scorModel.setUpwardFlexibility(20.0 + random.nextDouble() * 30.0);
                scorModel.setDownwardAdaptability(15.0 + random.nextDouble() * 25.0);
                
                // Set process-specific best practices
                switch (process) {
                    case PLAN:
                        scorModel.setBestPractices("Demand forecasting, S&OP, capacity planning");
                        scorModel.setMetrics("Forecast accuracy, planning cycle time, demand variability");
                        break;
                    case SOURCE:
                        scorModel.setBestPractices("Supplier collaboration, strategic sourcing, risk management");
                        scorModel.setMetrics("Supplier quality, delivery performance, cost savings");
                        break;
                    case MAKE:
                        scorModel.setBestPractices("Lean manufacturing, quality management, production optimization");
                        scorModel.setMetrics("Manufacturing cycle time, quality rates, productivity");
                        break;
                    case DELIVER:
                        scorModel.setBestPractices("Order management, logistics optimization, customer service");
                        scorModel.setMetrics("Order fulfillment rate, delivery time, customer satisfaction");
                        break;
                    case RETURN:
                        scorModel.setBestPractices("Reverse logistics, product recovery, sustainability");
                        scorModel.setMetrics("Return processing time, recovery rate, environmental impact");
                        break;
                }
                
                apicsSCORRepository.save(scorModel);
            }
        }
    }
    
    private Double calculateAverageOrderFulfillment() {
        return apicsSCORRepository.findAll().stream()
                .mapToDouble(s -> s.getOrderFulfillmentRate() != null ? s.getOrderFulfillmentRate() : 0.0)
                .average().orElse(0.0);
    }
    
    private Double calculateAverageSupplyChainCosts() {
        return apicsSCORRepository.findAll().stream()
                .mapToDouble(s -> s.getSupplyChainCosts() != null ? s.getSupplyChainCosts() : 0.0)
                .average().orElse(0.0);
    }
    
    private Double calculateAverageCashToCashCycle() {
        return apicsSCORRepository.findAll().stream()
                .mapToDouble(s -> s.getCashToCashCycleTime() != null ? s.getCashToCashCycleTime() : 0.0)
                .average().orElse(0.0);
    }
    
    private Double calculateAverageAssetTurns() {
        return apicsSCORRepository.findAll().stream()
                .mapToDouble(s -> s.getAssetTurns() != null ? s.getAssetTurns() : 0.0)
                .average().orElse(0.0);
    }
    
    private Double calculateAverageFlexibility() {
        return apicsSCORRepository.findAll().stream()
                .mapToDouble(s -> s.getUpwardFlexibility() != null ? s.getUpwardFlexibility() : 0.0)
                .average().orElse(0.0);
    }
}
