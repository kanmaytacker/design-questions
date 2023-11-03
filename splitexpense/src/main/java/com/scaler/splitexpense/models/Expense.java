package com.scaler.splitexpense.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.*;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    @Where(clause = "type = 'PAID'")
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    @Where(clause = "type = 'OWED'")
    private List<UserExpense> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;
}