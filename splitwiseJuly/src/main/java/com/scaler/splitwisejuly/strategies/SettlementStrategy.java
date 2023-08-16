package com.scaler.splitwisejuly.strategies;

import com.scaler.splitwisejuly.dtos.Transaction;
import com.scaler.splitwisejuly.models.Expense;

import java.util.List;

public interface SettlementStrategy {
   List<Transaction> settleUp(List<Expense> expenses);
}

// A -> B 100
