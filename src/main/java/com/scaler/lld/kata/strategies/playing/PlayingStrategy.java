package com.scaler.lld.kata.strategies.playing;

import com.scaler.lld.kata.models.Board;
import com.scaler.lld.kata.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
