package com.scaler.splitexpense.commands;

import java.util.Arrays;
import java.util.List;

// Step 1 - An abstraction over all commands
public interface Command {
    // 1. It needs check if it can execute against a particular user input
    // splitwise register
    boolean matches(String input);

    void execute(String input);

    static List<String> getTokens(String input) {
        return Arrays.stream(input.split(" ")).toList();
    }

    static String getCommand(String input) {
        return getTokens(input).get(0);
    }
}