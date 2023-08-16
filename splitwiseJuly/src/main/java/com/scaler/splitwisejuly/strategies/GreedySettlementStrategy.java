package com.scaler.splitwisejuly.strategies;

import com.scaler.splitwisejuly.dtos.Transaction;
import com.scaler.splitwisejuly.models.Expense;
import com.scaler.splitwisejuly.models.User;
import com.scaler.splitwisejuly.models.UserExpense;
import org.springframework.data.util.Pair;

import java.util.*;

public class GreedySettlementStrategy implements SettlementStrategy {
    // {}
    // { A: 100 }
    // { A: 100 + (-200) }
    // { A: 100 + (-200) + 300}
    // A -> 100
    // A -> -200
    // A -> 300
    private static Map<Long, Double> calculateBalances(List<Expense> expenses) {
        Map<Long, Double> balances = new HashMap<>();
        // Iterate over all the expenses
        for (Expense expense : expenses) {
            // Iterate over each user in the owed by
            for (UserExpense userExpense : expense.getOwedBy()) {
                User user = userExpense.getUser();
                // If user is not present, add 0.0
                if (!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }

                balances.put(user.getId(), balances.get(user.getId()) + userExpense.getAmount());
            }

            // Iterate over each user in paid by
            for (UserExpense userExpense : expense.getPaidBy()) {
                User user = userExpense.getUser();
                if (!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }

                // Subtract the paid By
                balances.put(user.getId(), balances.get(user.getId()) - userExpense.getAmount());
            }
        }

        return balances;
    }

    // A -> 100 B -> -100

    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        Map<Long, Double> balances = calculateBalances(expenses);
        // Create a heap
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((expense1, expense2) -> (int) (expense1.getSecond() - expense2.getSecond()));
        // Add nodes to the heap
        // [{A:100}, {B:200}]
        for (Map.Entry<Long, Double> balance : balances.entrySet()) {
            expenseTree.add(Pair.of(balance.getKey(), balance.getValue()));
        }

        List<Transaction> transactions = new ArrayList<>();
        while (expenseTree.size() > 1) {

            // Find the smallest pair - Minimum value
            Pair<Long, Double> smallestPair = expenseTree.first();

            // Find the largest pair - Maximum value
            Pair<Long, Double> largestPair = expenseTree.last();

            // Pay from minimum to maximum
            Transaction transaction = Transaction.builder()
                    .from(largestPair.getFirst())
                    .to(smallestPair.getFirst())
                    .amount(smallestPair.getSecond())
                    .build();

            // Remove both the users from our heap
            expenseTree.remove(largestPair);
            expenseTree.remove(smallestPair);

            // If the amount is not exact
            expenseTree.add(Pair.of(smallestPair.getFirst(), smallestPair.getSecond() + largestPair.getSecond()));
            transactions.add(transaction);
        }

        return transactions;
    }
}
//     A:1000
// B:200     C:200
