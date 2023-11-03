package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.ExpenseController;
import com.scaler.splitexpense.models.Expense;
import com.scaler.splitexpense.models.UserExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
// Step 2
public class SettleUpCommand implements Command {
    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (!command.equals(Commands.SETTLE_UP_COMMAND)) {
            return false;
        }

        return true;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing settle command");
        List<String> tokens = Command.getTokens(input);

    }
}