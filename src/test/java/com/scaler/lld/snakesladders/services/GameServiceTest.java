package com.scaler.lld.snakesladders.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.scaler.lld.snakesladders.models.Board;
import com.scaler.lld.snakesladders.models.Cell;
import com.scaler.lld.snakesladders.models.CellType;
import com.scaler.lld.snakesladders.models.Colour;
import com.scaler.lld.snakesladders.models.Game;
import com.scaler.lld.snakesladders.models.GameRequest;
import com.scaler.lld.snakesladders.models.Ladder;
import com.scaler.lld.snakesladders.models.Piece;
import com.scaler.lld.snakesladders.models.Player;
import com.scaler.lld.snakesladders.models.Snake;

import org.junit.Test;

public class GameServiceTest {

    private GameService gameService = new GameService();

    @Test
    public void testCreateGame() {

        GameRequest gameRequest = createGameRequest();
        Game game = gameService.createGame(gameRequest);

        assertEquals("If game has been created, it should have same number of players as the request",
                gameRequest.getPlayers().size(), game.getPlayers().size());

        Board board = game.getBoard();
        assertEquals("If board has been created, it should have same number of cells as the request",
                gameRequest.getBoardSize().intValue(), board.getCells().size());

        assertEquals("If board has been created, it should have same number of snakes as the request",
                1, filterCells(board.getCells(), CellType.SNAKE).size());

        assertEquals("If board has been created, it should have same number of ladders as the request",
                1, filterCells(board.getCells(), CellType.LADDER).size());
    }


    private List<Cell> filterCells(List<Cell> cells, CellType snake) {
        List<Cell> filteredCells = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.getType().equals(snake)) {
                filteredCells.add(cell);
            }
        }
        return filteredCells;
    }


    private GameRequest createGameRequest() {
        return GameRequest
                .builder()
                .boardSize(100)
                .players(Arrays.asList(
                        Player
                                .builder()
                                .color(Colour.BLUE)
                                .pieces(Arrays.asList(new Piece(Colour.BLUE)))
                                .build(),
                        Player
                                .builder()
                                .color(Colour.RED)
                                .pieces(Arrays.asList(new Piece(Colour.RED)))
                                .build()))
                .specialCells(
                        Arrays.asList(
                                Snake.builder().type(CellType.SNAKE).index(10).endIndex(2).build(),
                                Ladder.builder().type(CellType.LADDER).index(5).endIndex(8).build()))
                .build();
    }

}
