package com.projecten.finance.controller;

import com.projecten.finance.entity.Budget;
import com.projecten.finance.service.BudgetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin(origins = "http://localhost:4200")
public class BudgetController {

    private final BudgetService service;

    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Budget> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Budget getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Budget create(@RequestBody Budget budget) {
        return service.create(budget);
    }

    @PutMapping("/{id}")
    public Budget update(@PathVariable Long id, @RequestBody Budget budget) {
        return service.update(id, budget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
