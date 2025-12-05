package com.projecten.finance.service;

import com.projecten.finance.entity.AlertThreshold;
import com.projecten.finance.repository.AlertThresholdRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertThresholdService {

    private final AlertThresholdRepository repo;

    public AlertThresholdService(AlertThresholdRepository repo) {
        this.repo = repo;
    }

    public List<AlertThreshold> getAll() {
        return repo.findAll();
    }

    public AlertThreshold getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert threshold not found"));
    }

    public AlertThreshold create(AlertThreshold a) {
        return repo.save(a);
    }

    public AlertThreshold update(Long id, AlertThreshold updated) {
        AlertThreshold a = getById(id);
        a.setPercentage(updated.getPercentage());
        a.setMessage(updated.getMessage());
        return repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}