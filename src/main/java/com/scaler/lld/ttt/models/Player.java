package com.scaler.lld.ttt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {
    private GameSymbol symbol;

    public Player() {
    }

    public abstract BoardCell makeMove(Board board);
}
