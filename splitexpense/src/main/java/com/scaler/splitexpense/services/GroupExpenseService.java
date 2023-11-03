package com.scaler.splitexpense.services;

import com.scaler.splitexpense.models.GroupExpense;
import com.scaler.splitexpense.repositories.GroupExpenseRepository;
import com.scaler.splitexpense.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupExpenseService {
    private GroupExpenseRepository groupExpenseRepository;
    public GroupExpense createGroupExpense(GroupExpense groupExpense) {
        return groupExpenseRepository.save(groupExpense);
    }
}
