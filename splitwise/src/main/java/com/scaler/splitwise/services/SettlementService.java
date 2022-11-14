package com.scaler.splitwise.services;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;
import com.scaler.splitwise.strategies.SettlementStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SettlementService {
    private SettlementStrategy settlementStrategy;

    public List<SettleUpTransaction> settle(List<Expense> expenses) {
        return settlementStrategy.settleExpenses(expenses);
    }
}
