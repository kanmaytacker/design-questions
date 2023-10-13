package com.scaler.lld.ttt.stratergies.winning;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.GameSymbol;

public class ColumnWinningStratergy implements WinningStratergy {
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        int colSize = board.getSize();
        for(int i=0; i<colSize; i++){//Iterate on each column
            boolean didWin = true;
            for(int j=0; j<colSize; j++){//iterate on each row column
                GameSymbol currentSymbol =  board.getCells().get(j).get(i).getSymbol();
                if(currentSymbol == null || currentSymbol != symbol){
                    didWin = false;
                    break;
                }
            }
            if(didWin) return true;
        }

        return false;
    }
}
