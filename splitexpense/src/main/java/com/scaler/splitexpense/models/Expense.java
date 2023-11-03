package com.scaler.splitexpense.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense", fetch = FetchType.EAGER)
    @Where(clause = "type = 0")
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense", fetch = FetchType.EAGER)
    @Where(clause = "type = 1")
    private List<UserExpense> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;
}