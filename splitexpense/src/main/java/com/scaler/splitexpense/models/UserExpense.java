package com.scaler.splitexpense.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    private Double amount;

    @Enumerated
    private ExpenseType type;
}