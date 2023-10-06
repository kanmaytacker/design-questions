package com.scaler.lld.kata.models;

import lombok.*;



@NoArgsConstructor
@Builder
public class BoardCell {
    private int row;
    private int column;
    private GameSymbol symbol;
}
