package com.scaler.splitwise.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    @Enumerated
    private Currency currency;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @ElementCollection
    Map<User, Long> paidBy = new HashMap<>();

    @ElementCollection
    Map<User, Long> owedBy = new HashMap<>();
}
