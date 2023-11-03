package com.scaler.splitexpense.repositories;

import com.scaler.splitexpense.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}