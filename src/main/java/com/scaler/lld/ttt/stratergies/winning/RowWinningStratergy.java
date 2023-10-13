package com.scaler.lld.ttt.stratergies.winning;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.BoardCell;
import com.scaler.lld.ttt.models.GameSymbol;

import java.util.List;

public class RowWinningStratergy implements WinningStratergy {
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        for(List<BoardCell> rows: board.getCells()){
            boolean didWin = true;
            for(BoardCell cell: rows){
                if(cell.getSymbol() == null || cell.getSymbol() != symbol){
                    didWin = false;
                    break;
                }
            }
            if(didWin) {
                return true;
            }
        }
        return false;
    }
}
