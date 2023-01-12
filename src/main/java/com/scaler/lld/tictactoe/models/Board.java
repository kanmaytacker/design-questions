package com.scaler.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int rows, int columns) {
       IntStream.range(0, rows).forEach(row -> {
           List<BoardCell> rowCells = new ArrayList<>();
           IntStream.range(0, columns).forEach(column -> rowCells.add(new BoardCell(row, column)));
           cells.add(rowCells);
       });
    }

    public boolean isEmpty(int row, int column) {
        return cells.get(row).get(column).getSymbol() == null;
    }

    public List<BoardCell> getAvailableCells() {
        return cells.stream().flatMap(List::stream).filter(cell -> cell.getSymbol() == null).toList();
    }
}
