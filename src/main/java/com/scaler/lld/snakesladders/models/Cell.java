package com.scaler.lld.snakesladders.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class Cell {
    
    private Integer index;
    private CellType type;
    private List<Piece> pieces = new ArrayList<>();
    
    public abstract Integer getNextPosition();

    public void removePiece(Piece piece) {
    }
    public void addPiece(Piece piece) {
    }
}
