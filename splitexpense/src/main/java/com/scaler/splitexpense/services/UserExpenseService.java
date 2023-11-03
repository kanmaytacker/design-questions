package com.scaler.splitexpense.services;

import com.scaler.splitexpense.models.UserExpense;
import com.scaler.splitexpense.repositories.UserExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExpenseService {
    private UserExpenseRepository userExpenseRepository;
    public UserExpense createUserExpense(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
