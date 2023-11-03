package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expense_groups")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();
}