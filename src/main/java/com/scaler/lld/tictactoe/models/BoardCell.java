package com.scaler.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCell {
    private Integer row;
    private Integer column;
    private GameSymbol symbol;
}
