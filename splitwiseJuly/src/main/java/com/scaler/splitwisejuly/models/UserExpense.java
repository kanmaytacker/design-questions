package com.scaler.splitwisejuly.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;

    private Double amount;

    @Enumerated
    private ExpenseType type;
}