package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {

    @Override
    public List<SettleUpTransaction> settleExpenses(List<Expense> expenses) {
        return Collections.emptyList();
    }
}
