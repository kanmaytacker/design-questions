package com.scaler.splitexpense.strategies;

import com.scaler.splitexpense.dtos.SettleUpTransaction;
import com.scaler.splitexpense.models.Expense;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.models.UserExpense;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {

    private static Map<Long, Double> prepareInitialState(List<Expense> expenses) {
        Map<Long, Double> transactions = new HashMap<>();
        for (Expense expense : expenses) {
            for (UserExpense userExpense : expense.getOwedBy()) {
                User user = userExpense.getUser();
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) + userExpense.getAmount());
            }

            for (UserExpense userExpense : expense.getPaidBy()) {
                User user = userExpense.getUser();
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) - userExpense.getAmount());
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