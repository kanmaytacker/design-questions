package com.scaler.splitwise.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.scaler.splitwise.dtos.CreateExpenseDto;
import com.scaler.splitwise.dtos.CreateGroupDto;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.GroupExpense;
import com.scaler.splitwise.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    @PostMapping("/group")
    public Group createGroup(@RequestBody CreateGroupDto request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        System.out.println(ow.writeValueAsString(request));
        return groupService.createGroup(request);
    }

    @GetMapping("/group/{id}")
    public Group getGroup(@PathVariable Long id) throws JsonProcessingException {
        Group group = groupService.getGroup(id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        System.out.println(ow.writeValueAsString(group));
        return group;
    }

    @PostMapping("/group/{id}/expense")
    public GroupExpense createGroupExpense(@PathVariable Long id, @RequestBody CreateExpenseDto request) {
        return groupService.createGroupExpense(id, request);
    }
}
