package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.ExpenseController;
import com.scaler.splitexpense.dtos.CreateExpenseRequest;
import com.scaler.splitexpense.models.CreateUserExpenseRequest;
import com.scaler.splitexpense.models.Expense;
import com.scaler.splitexpense.models.ExpenseType;
import com.scaler.splitexpense.models.UserExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Step 2 - Create the concrete command classes
@Component
@AllArgsConstructor
public class AddUserExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (!command.equals(Commands.ADD_USER_EXPENSE)) {
            return false;
        }

        return true;
    }


    @Override
    public void execute(String input) {
        System.out.println("Executing create expense command");
        List<String> tokens = Command.getTokens(input);
        CreateUserExpenseRequest request = CreateUserExpenseRequest.builder()
                .expenseId(Long.valueOf(tokens.get(1)))
                .userId(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(tokens.get(4)))
                .build();

        UserExpense expense = expenseController.addUserExpense(request);
        System.out.println("Created expense with id: " + expense.getId());
    }
}