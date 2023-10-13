package com.scaler.lld.ttt.stratergies.winning;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.BoardCell;
import com.scaler.lld.ttt.models.GameSymbol;

public class DiagnolWinningStratergy implements WinningStratergy {
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        int boardSize = board.getSize();
        boolean didWin = true;
        //Check from left top to right bottom diagonal
        for(int i=0; i<boardSize;i++){
            GameSymbol currSymbol = board.getCells().get(i).get(i).getSymbol();
            if(currSymbol == null || currSymbol != symbol){
                didWin = false;
                break;
            }
        }
        if(didWin) return true;
        //check from right top to left bottom diagonal
        didWin = true;
        for(int i=0,j=boardSize-1; i<boardSize; i++,j--){
            GameSymbol currSymbol = board.getCells().get(i).get(j).getSymbol();
            if(currSymbol == null || currSymbol != symbol){
                didWin = false;
                break;
            }
        }
        return didWin;
    }
}
