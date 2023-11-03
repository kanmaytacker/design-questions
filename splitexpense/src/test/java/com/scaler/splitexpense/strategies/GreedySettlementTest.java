package com.scaler.splitexpense.strategies;


import com.scaler.splitexpense.dtos.SettleUpTransaction;
import com.scaler.splitexpense.models.Expense;
import com.scaler.splitexpense.models.ExpenseType;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.models.UserExpense;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class GreedySettlementTest {

    private SettlementStrategy settlementStrategy = null;

    @BeforeEach
    public void setUp() {
        settlementStrategy = new GreedySettlementStrategy();
    }

    @Test
    public void testSettleUp() {
        List<Expense> expenses = createSimpleExpenses2();
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
        expense.setOwedBy(castExpenseMap(expense, owedBy, ExpenseType.OWED));
        expense.setPaidBy(castExpenseMap(expense, paidBy, ExpenseType.PAID));
        return expense;
    }

    private List<UserExpense> castExpenseMap(Expense expense, Map<Long, Double> original, ExpenseType expenseType) {
        return original.entrySet().stream().map(entry -> {
            User user = new User();
            user.setId(entry.getKey());

            UserExpense userExpense = new UserExpense();
            userExpense.setExpense(expense);
            userExpense.setUser(user);
            userExpense.setType(expenseType);
            userExpense.setAmount(entry.getValue());
            return userExpense;
        }).toList();
    }
}