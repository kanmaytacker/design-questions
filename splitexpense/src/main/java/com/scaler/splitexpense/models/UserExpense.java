package com.scaler.splitexpense.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpense extends BaseModel {

    private User user;

    private Expense expense;

    private Double amount;

    private ExpenseType type;
}