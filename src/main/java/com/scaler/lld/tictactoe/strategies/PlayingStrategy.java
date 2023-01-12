package com.scaler.lld.tictactoe.strategies;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;
import com.scaler.lld.tictactoe.models.Move;

public interface PlayingStrategy {
    Move play(Board board);
}
