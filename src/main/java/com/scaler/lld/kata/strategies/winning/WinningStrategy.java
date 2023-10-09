package com.scaler.lld.kata.strategies.winning;

import com.scaler.lld.kata.models.Board;
import com.scaler.lld.kata.models.GameSymbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, GameSymbol symbol);
}

// Task 4 - Implement column winner and row winner
