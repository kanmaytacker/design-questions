package com.scaler.splitexpense.repositories;

import com.scaler.splitexpense.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
}