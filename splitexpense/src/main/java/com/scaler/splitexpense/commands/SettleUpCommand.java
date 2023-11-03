package com.scaler.splitexpense.commands;

import java.util.Arrays;
import java.util.List;

public class SettleUpCommand implements Command {
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(Commands.SETTLE_UP_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
