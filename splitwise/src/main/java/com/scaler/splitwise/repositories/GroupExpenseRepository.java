package com.scaler.splitwise.repositories;

import com.scaler.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
    public List<GroupExpense> findGroupExpensesByGroup_Id(Long groupId);

}
