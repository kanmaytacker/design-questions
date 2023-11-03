package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupExpense extends BaseModel {

    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}