package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class GroupExpense extends BaseModel {

    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}

// G1 Dinner(GE1) -> E1
// G1 Breakfast(GE2) -> E2
