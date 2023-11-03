package com.scaler.splitexpense.services;

import com.scaler.splitexpense.dtos.CreateExpenseRequest;
import com.scaler.splitexpense.dtos.CreateGroupExpenseRequest;
import com.scaler.splitexpense.exceptions.ExpenseNotFoundException;
import com.scaler.splitexpense.exceptions.GroupNotFoundException;
import com.scaler.splitexpense.models.*;
import com.scaler.splitexpense.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {
    private UserService userService;
    private UserExpenseService userExpenseService;
    private GroupService groupService;
    private GroupExpenseService groupExpenseService;

    private ExpenseRepository expenseRepository;
    public Expense createExpense(CreateExpenseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();
        return expenseRepository.save(expense);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        Expense expense = expenseRepository.
                findById(request.getExpenseId())
                .orElseThrow(() -> new ExpenseNotFoundException(request.getExpenseId()));
        User user = userService.getUser(request.getUserId());
        UserExpense userExpense = UserExpense.builder()
                .expense(expense)
                .user(user)
                .amount(request.getAmount())
                .type(request.getType())
                .build();
        return userExpenseService.createUserExpense(userExpense);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        Group group = groupService.getGroup(request.getGroupId());
        if (group == null) {
            throw new GroupNotFoundException(request.getGroupId());
        }
        List<User> users = userService.getUsers(request.getUserIds());
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();
        expenseRepository.save(expense);

        GroupExpense groupExpense = GroupExpense.builder()
                .group(group)
                .expense(expense)
                .build();
        return groupExpenseService.createGroupExpense(groupExpense);
    }

    public Expense getExpense(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }
}
