package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.CreateExpenseDto;
import com.scaler.splitwise.dtos.CreateGroupDto;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.GroupExpense;
import com.scaler.splitwise.models.SettleUpTransaction;
import com.scaler.splitwise.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    @PostMapping("/group")
    public Group createGroup(@RequestBody CreateGroupDto request) {
        return groupService.createGroup(request);
    }

    @GetMapping("/group/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping("/group/{id}/expense")
    public GroupExpense createGroupExpense(@PathVariable Long id, @RequestBody CreateExpenseDto request) {
        return groupService.createGroupExpense(id, request);
    }

    @GetMapping("/group/{id}/settle")
    public List<SettleUpTransaction> settle(@PathVariable Long id) {
        return groupService.settle(id);
    }

    @GetMapping("/group/{id}/expense")
    public List<GroupExpense> getExpenses(@PathVariable Long id) {
        return groupService.getExpenses(id);
    }
}
