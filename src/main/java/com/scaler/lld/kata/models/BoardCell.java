package com.scaler.lld.kata.models;

import lombok.*;



@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BoardCell {
    private int row;
    private int column;
    private GameSymbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
