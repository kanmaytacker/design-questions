package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettlementStrategy {
    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);

}
