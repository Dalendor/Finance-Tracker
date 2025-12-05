package com.projecten.finance.service;

import com.projecten.finance.entity.Transaction;
import com.projecten.finance.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public Transaction getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public Transaction create(Transaction t) {
        return repo.save(t);
    }

    public Transaction update(Long id, Transaction updated) {
        Transaction t = getById(id);
        t.setDescription(updated.getDescription());
        t.setAmount(updated.getAmount());
        t.setDate(updated.getDate());
        t.setIncome(updated.isIncome());
        t.setCategory(updated.getCategory());
        return repo.save(t);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}