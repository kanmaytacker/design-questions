package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.CreateExpenseDto;
import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService service;

    @PostMapping("/expense")
    public Expense createExpense(@RequestBody CreateExpenseDto request) {
        return service.createExpense(request);
    }

    @GetMapping("/expense/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return service.getExpense(id);
    }

    @GetMapping("/expense")
    public List<Expense> getExpenses() {
        return service.getExpenses();
    }

}
