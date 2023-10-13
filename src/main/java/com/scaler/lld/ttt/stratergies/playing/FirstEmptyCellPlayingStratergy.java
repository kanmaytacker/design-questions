package com.scaler.lld.ttt.stratergies.playing;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.BoardCell;

public class FirstEmptyCellPlayingStratergy implements PlayingStratergy {
    @Override
    public BoardCell makeMove(Board board) {
        return board.getEmptyCells().get(0);
    }
}
