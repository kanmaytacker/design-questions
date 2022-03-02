package com.scaler.lld.tictactoe.strategies;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;

public interface PlayingStrategy {
    BoardCell play(Board board);
}
