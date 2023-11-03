package com.scaler.splitexpense.commands;

import java.util.Arrays;
import java.util.List;

// Step 1 - Create a parent command interface
public interface Command {
    boolean matches(String input); // splitwise register Tantia
    void execute(String input);

    default String getCommand(String input) {
        // Check if the first token is the same as command name
        return getTokens(input).get(0);
    }

    default List<String> getTokens(String input) {
        return Arrays.stream(input.split(" ")).toList();
    }
}
