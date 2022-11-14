package com.scaler.splitwise.services;

import com.scaler.splitwise.dtos.CreateExpenseDto;
import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ExpenseService {
    private UserService userService;
    private ExpenseRepository repository;

    private static Expense buildExpense(CreateExpenseDto request, Map<Long, User> idToUsers) {
        Expense expense = new Expense();
        expense.setDescription(request.getDescription());
        expense.setAmount(request.getAmount());
        expense.setCurrency(request.getCurrency());
        expense.setCreatedBy(idToUsers.get(request.getCreatedBy()));
        expense.setUsers(request.getUsers().stream().map(idToUsers::get).collect(Collectors.toList()));
        expense.setPaidBy(fromUserIds(request.getPaidBy(), idToUsers));
        expense.setOwedBy(fromUserIds(request.getOwedBy(), idToUsers));
        return expense;
    }

    private static Map<User, Long> fromUserIds(Map<Long, Long> users, Map<Long, User> idToUsers) {
        return users.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> idToUsers.get(entry.getKey()),
                        Map.Entry::getValue
                ));
    }

    public Expense createExpense(CreateExpenseDto request) {
        Set<Long> userIds = Stream.concat(request.getUsers().stream(), Stream.of(request.getCreatedBy())).collect(Collectors.toSet());
        List<User> users = userService.getUsers(userIds);

        Map<Long, User> idToUsers = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        Expense expense = buildExpense(request, idToUsers);
        return repository.save(expense);
    }


    public Expense getExpense(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Missing expense!"));
    }

    public List<Expense> getExpenses() {
        return repository.findAll();
    }
}
