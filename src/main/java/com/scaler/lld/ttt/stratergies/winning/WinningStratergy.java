package com.scaler.lld.ttt.stratergies.winning;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.GameSymbol;

public interface WinningStratergy {
    boolean checkWinner(Board board, GameSymbol symbol);
}
