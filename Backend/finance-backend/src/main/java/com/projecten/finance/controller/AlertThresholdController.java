package com.projecten.finance.controller;

import com.projecten.finance.entity.AlertThreshold;
import com.projecten.finance.service.AlertThresholdService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertThresholdController {

    private final AlertThresholdService service;

    public AlertThresholdController(AlertThresholdService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlertThreshold> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AlertThreshold getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AlertThreshold create(@RequestBody AlertThreshold a) {
        return service.create(a);
    }

    @PutMapping("/{id}")
    public AlertThreshold update(@PathVariable Long id, @RequestBody AlertThreshold a) {
        return service.update(id, a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}