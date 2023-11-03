package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;
}

// E1 - Paid  - A 100 B 200
//    - Owed  - A 150 B 150

// E1 => UE1 A 100 PAID
// E1 => UE2 B 200 PAID

// E1 => UE3 A 150 OWED
// E1 => UE4 A 150 OWED

// E2 => UE1

