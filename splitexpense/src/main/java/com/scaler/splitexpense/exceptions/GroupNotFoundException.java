package com.scaler.splitexpense.exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(Long groupId) {
        super("Group not found: " + groupId);
    }
}
