package com.projecten.finance.service;

import com.projecten.finance.entity.Budget;
import com.projecten.finance.repository.BudgetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository repo;

    public BudgetService(BudgetRepository repo) {
        this.repo = repo;
    }

    public List<Budget> getAll() {
        return repo.findAll();
    }

    public Budget getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public Budget create(Budget budget) {
        return repo.save(budget);
    }

    public Budget update(Long id, Budget updated) {
        Budget b = getById(id);
        b.setName(updated.getName());
        b.setMonthlyLimit(updated.getMonthlyLimit());
        return repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}