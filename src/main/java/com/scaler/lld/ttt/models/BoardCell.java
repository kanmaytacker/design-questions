package com.scaler.lld.ttt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardCell {

    private int row, col;

    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }

    public BoardCell(int row, int column) {
        this.row = row;
        this.col = column;
    }

    private GameSymbol symbol;


}
