package com.scaler.splitexpense.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    private Date createdOn;

    private Group group;

    private List<User> users = new ArrayList<>();

    private List<UserExpense> paidBy = new ArrayList<>();

    private List<UserExpense> owedBy = new ArrayList<>();
}