package com.scaler.splitexpense.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserExpenseRequest {
    private Long expenseId;
    private Long userId;
    private Double amount;
    private ExpenseType type;
}
