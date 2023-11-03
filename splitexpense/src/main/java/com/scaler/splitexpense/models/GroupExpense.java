package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupExpense extends BaseModel {

    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}