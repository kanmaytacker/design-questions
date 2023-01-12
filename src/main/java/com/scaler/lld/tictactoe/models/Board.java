package com.scaler.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int rows, int columns) {
        List<BoardCell> columnCells = Collections.nCopies(columns, new BoardCell());
        List<List<BoardCell>> rowCells = Collections.nCopies(rows, columnCells);
        this.cells = rowCells;
    }

    public boolean isEmpty(int row, int column) {
        return cells.get(row).get(column).getSymbol() == null;
    }

    public List<BoardCell> getAvailableCells() {
        return cells.stream().flatMap(List::stream).filter(cell -> cell.getSymbol() == null).toList();
    }
}
