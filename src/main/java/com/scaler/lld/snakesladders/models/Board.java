package com.scaler.lld.snakesladders.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    List<Cell> cells = new ArrayList<>();

    public Board(int size, List<Cell> specialCells) {
        this.cells = createBoard(size, parseSpecialCells(specialCells));
    }

    private Map<Integer, Cell> parseSpecialCells(List<Cell> cells) {
        Map<Integer, Cell> specialCells = new HashMap<>();
        for (Cell cell : cells) {
            specialCells.put(cell.getIndex(), cell);
        }
        return specialCells;
    }

    private List<Cell> createBoard(int size, Map<Integer, Cell> specialCells) {
        
        List<Cell> cells = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            
            Cell cell = constructCell(index, specialCells);
            cell.setIndex(index);
            cells.add(cell);
        }
        return cells;
    }

    private Cell constructCell(int index, Map<Integer, Cell> specialCells) {
        if (specialCells.containsKey(index)) {
            return specialCells.get(index);
        }

        return BaseCell.builder().type(CellType.BASE).index(index).build();
    }

    public Cell getCurrentCell(Player player) {
        for (Cell cell : cells) {
            if (cell.getPieces().contains(player.getPieces().get(0))) {
                return cell;
            }
        }
        throw new RuntimeException("Player not found");
    }

    public Cell getNextCell(Cell currentCell, int rollValue) {
        return null;
    }
}
