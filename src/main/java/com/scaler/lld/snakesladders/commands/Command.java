package com.scaler.lld.snakesladders.commands;

public interface Command {
    
    void execute(String command);

    boolean matches(String command);
}
