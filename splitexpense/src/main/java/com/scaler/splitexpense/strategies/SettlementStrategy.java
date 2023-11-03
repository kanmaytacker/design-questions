package com.scaler.splitexpense.strategies;

import com.scaler.splitexpense.dtos.SettleUpTransaction;
import com.scaler.splitexpense.models.Expense;


import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);

}