package com.scaler.splitexpense.controllers;

import com.scaler.splitexpense.dtos.CreateGroupRequest;
import com.scaler.splitexpense.models.Group;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;
    public Group createGroup(CreateGroupRequest request) {
        return groupService.createGroup(request);
    }
}
