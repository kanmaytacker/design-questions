package com.scaler.splitwisejuly.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    private Date createdOn;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany
    private List<UserExpense> owedBy = new ArrayList<>();
}

// 1000
// A -> 100 INR CARD, B -> 500 INR UPI C -> 400 - PaidBy
// A -> B -> C -> D -> E -> 200, Owedby
