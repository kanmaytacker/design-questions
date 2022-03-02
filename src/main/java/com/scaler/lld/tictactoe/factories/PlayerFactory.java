package com.scaler.lld.tictactoe.factories;

import com.scaler.lld.tictactoe.models.Bot;
import com.scaler.lld.tictactoe.models.HumanPlayer;

public class PlayerFactory {
    
    public static HumanPlayer.HumanPlayerBuilder getHumanPlayer() {
        return HumanPlayer.builder();
    }

    public static Bot.BotBuilder getBotPlayer() {
        return Bot.builder();
    }
    
}
