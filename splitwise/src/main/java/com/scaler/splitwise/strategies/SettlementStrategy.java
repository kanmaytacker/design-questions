package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;

import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);

}
