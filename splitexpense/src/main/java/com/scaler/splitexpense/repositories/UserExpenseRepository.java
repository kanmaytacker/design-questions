package com.scaler.splitexpense.repositories;

import com.scaler.splitexpense.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
}