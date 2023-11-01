package com.scaler.splitexpense.commands;

// Step 1 - An abstraction over all commands
public interface Command {
    // 1. It needs check if it can execute against a particular user input
    // splitwise register
    boolean matches(String input);

    void execute(String input);
}