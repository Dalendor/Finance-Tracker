package com.projecten.finance.repository;

import com.projecten.finance.entity.Transaction;
import com.projecten.finance.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByBudgetAndDateBetweenAndIsIncomeFalse(
            Budget budget,
            LocalDate start,
            LocalDate end
    );
}
