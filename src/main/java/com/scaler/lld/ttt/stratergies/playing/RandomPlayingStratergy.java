package com.scaler.lld.ttt.stratergies.playing;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.BoardCell;

import java.util.List;

public class RandomPlayingStratergy implements PlayingStratergy{
    @Override
    public BoardCell makeMove(Board board) {
        //get list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();
        //pick a random cell from the empty cells
        int randomIdx = (int)(Math.random() * emptyCells.size());
        return emptyCells.get(randomIdx);
    }
}
