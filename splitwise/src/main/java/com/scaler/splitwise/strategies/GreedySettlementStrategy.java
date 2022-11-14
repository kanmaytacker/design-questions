package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.SettleUpTransaction;
import com.scaler.splitwise.models.User;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {

    private static Map<Long, Double> prepareInitialState(List<Expense> expenses) {
        Map<Long, Double> transactions = new HashMap<>();
        for (Expense expense : expenses) {
            for (User user : expense.getOwedBy().keySet()) {
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) + expense.getOwedBy().get(user));
            }

            for (User user : expense.getPaidBy().keySet()) {
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) - expense.getPaidBy().get(user));
            }
        }
        return transactions;
    }

    @Override
    public List<SettleUpTransaction> settleExpenses(List<Expense> expenses) {
        Map<Long, Double> initialState = prepareInitialState(expenses);
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((left, right) -> (int) (left.getSecond() - right.getSecond()));
        for (Map.Entry<Long, Double> entry : initialState.entrySet()) {
            expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
        }


        List<SettleUpTransaction> transactions = new ArrayList<>();

        while (expenseTree.size() > 1) {
            Pair<Long, Double> smallestPair = expenseTree.first();
            Pair<Long, Double> largestPair = expenseTree.last();

            SettleUpTransaction transaction = SettleUpTransaction.builder()
                    .from(largestPair.getFirst())
                    .to(smallestPair.getFirst())
                    .amount(largestPair.getSecond()).build();

            expenseTree.remove(largestPair);
            expenseTree.remove(smallestPair);

            expenseTree.add(Pair.of(smallestPair.getFirst(), smallestPair.getSecond() + largestPair.getSecond()));
            transactions.add(transaction);
        }

        return transactions;
    }
}
