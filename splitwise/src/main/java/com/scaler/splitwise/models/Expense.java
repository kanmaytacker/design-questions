package com.scaler.splitwise.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Expense extends BaseModel {

    @ElementCollection
    Map<User, Long> paidBy = new HashMap<>();
    @ElementCollection
    Map<User, Long> owedBy = new HashMap<>();
    private String description;
    private Double amount;
    @Enumerated
    private Currency currency;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> users = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Expense expense = (Expense) o;
        return getId() != null && Objects.equals(getId(), expense.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "description = " + getDescription() + ", " +
                "amount = " + getAmount() + ", " +
                "currency = " + getCurrency() + ")";
    }
}
