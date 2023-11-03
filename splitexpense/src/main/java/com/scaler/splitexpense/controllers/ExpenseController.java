package com.scaler.splitexpense.controllers;

import com.scaler.splitexpense.dtos.CreateExpenseRequest;
import com.scaler.splitexpense.dtos.CreateGroupExpenseRequest;
import com.scaler.splitexpense.models.*;
import com.scaler.splitexpense.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ExpenseController {
    private ExpenseService expenseService;
    public Expense createExpense(CreateExpenseRequest request) {
        return expenseService.createExpense(request);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        return expenseService.addUserExpense(request);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        return expenseService.createGroupExpense(request);
    }

    public Expense getExpense(Long id) {
        return expenseService.getExpense(id);
    }
}
