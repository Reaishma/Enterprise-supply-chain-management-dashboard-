
package com.scm.dashboard.controller;

import com.scm.dashboard.model.APICSSCORModel;
import com.scm.dashboard.service.APICSSCORService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/apics")
@CrossOrigin(origins = "*")
public class APICSController {
    
    @Autowired
    private APICSSCORService apicsSCORService;
    
    @GetMapping("/scor")
    public ResponseEntity<List<APICSSCORModel>> getAllSCORProcesses() {
        return ResponseEntity.ok(apicsSCORService.getAllSCORProcesses());
    }
    
    @GetMapping("/scor/{id}")
    public ResponseEntity<APICSSCORModel> getSCORProcessById(@PathVariable Long id) {
        APICSSCORModel scorModel = apicsSCORService.getSCORProcessById(id);
        return scorModel != null ? ResponseEntity.ok(scorModel) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/scor/process/{process}")
    public ResponseEntity<APICSSCORModel> getSCORProcessByType(@PathVariable String process) {
        try {
            APICSSCORModel.SCORProcess scorProcess = APICSSCORModel.SCORProcess.valueOf(process.toUpperCase());
            APICSSCORModel scorModel = apicsSCORService.getSCORProcessByType(scorProcess);
            return scorModel != null ? ResponseEntity.ok(scorModel) : ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/scor")
    public ResponseEntity<APICSSCORModel> createSCORProcess(@RequestBody APICSSCORModel scorModel) {
        return ResponseEntity.ok(apicsSCORService.createSCORProcess(scorModel));
    }
    
    @PutMapping("/scor/{id}")
    public ResponseEntity<APICSSCORModel> updateSCORProcess(@PathVariable Long id, @RequestBody APICSSCORModel scorModel) {
        scorModel.setId(id);
        return ResponseEntity.ok(apicsSCORService.updateSCORProcess(scorModel));
    }
    
    @DeleteMapping("/scor/{id}")
    public ResponseEntity<Void> deleteSCORProcess(@PathVariable Long id) {
        apicsSCORService.deleteSCORProcess(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getAPICSDashboardMetrics() {
        return ResponseEntity.ok(apicsSCORService.getAPICSDashboardMetrics());
    }
    
    @PostMapping("/initialize")
    public ResponseEntity<String> initializeAPICSData() {
        apicsSCORService.initializeAPICSData();
        return ResponseEntity.ok("APICS SCOR data initialized successfully");
    }
}
