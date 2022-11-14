package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;
import com.scaler.splitwise.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotEquals;

public class GreedySettlementTest {

    private SettlementStrategy settlementStrategy = null;

    @Before
    public void setUp() {
        settlementStrategy = new GreedySettlementStrategy();
    }

    @Test
    public void testSettleUp() {
        List<Expense> expenses = createSimpleExpenses();
        List<SettleUpTransaction> transactions = settlementStrategy.settleExpenses(expenses);
        assertNotEquals("If expenses is not empty, transactions should not be zero", 0, transactions.size());

        System.out.println("Number of transactions :" + transactions.size());
        for (SettleUpTransaction transaction : transactions) {
            System.out.println("User: " + transaction.getFrom() + " has to pay User :" + transaction.getTo() + " amount: " + transaction.getAmount());
        }
    }

    private List<Expense> createSimpleExpenses() {
        return List.of(expense(100.0, Map.of(1L, 50.0, 2L, 50.0), Map.of(1L, 100.0)));
    }

    private List<Expense> createSimpleExpenses2() {
        return List.of(expense(110.0, Map.of(1L, 40.0, 2L, 50.0, 3L, 20.0), Map.of(1L, 110.0)));
    }

    private Expense expense(Double amount, Map<Long, Double> owedBy, Map<Long, Double> paidBy) {
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setOwedBy(castExpenseMap(owedBy));
        expense.setPaidBy(castExpenseMap(paidBy));
        return expense;
    }

    private Map<User, Double> castExpenseMap(Map<Long, Double> original) {
        return original.entrySet().stream().collect(Collectors.toMap(entry -> {
            User user = new User();
            user.setId(entry.getKey());
            return user;
        }, Map.Entry::getValue));
    }
}
