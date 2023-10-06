package com.scaler.lld.kata.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {

    private GameSymbol symbol;

    public abstract BoardCell makeMove(Board board);
}
