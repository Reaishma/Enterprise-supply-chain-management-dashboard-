
package com.scm.dashboard.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
    
    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard.html";
    }
    
    @GetMapping("/dashboard.html")
    public ResponseEntity<Resource> getDashboard() {
        Resource resource = new ClassPathResource("static/dashboard.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }
}
