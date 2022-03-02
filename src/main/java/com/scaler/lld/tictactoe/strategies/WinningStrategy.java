package com.scaler.lld.tictactoe.strategies;

import java.util.List;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.Player;

public interface WinningStrategy {
    public Player checkWinner(Board board, List<Player> players);
}
