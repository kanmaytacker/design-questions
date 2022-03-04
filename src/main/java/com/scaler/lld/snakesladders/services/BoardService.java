package com.scaler.lld.snakesladders.services;

import com.scaler.lld.snakesladders.models.Board;
import com.scaler.lld.snakesladders.models.Cell;
import com.scaler.lld.snakesladders.models.Game;
import com.scaler.lld.snakesladders.models.Player;

public class BoardService {

    private GameService gameService = new GameService();

    public Board makeMove(Integer gameId, Integer playerId) {
        
        Game game = gameService.getGame(gameId);
        int rollValue = game.rollDice();
        
        Player player = getPlayer(game, playerId);
        Board updateBoard = updateBoard(game.getBoard(), player, rollValue);
        return updateBoard;
    }

    private Player getPlayer(Game game, Integer playerId) {
        for (Player player : game.getPlayers()) {
            if (player.getUser().getId().equals(playerId)) {
                return player;
            }
        }
        throw new RuntimeException("Player not found");
    }

    private Board updateBoard(Board board, Player player, int rollValue) {
        
        Cell currentCell = board.getCurrentCell(player);
        Cell nextCell = board.getNextCell(currentCell, rollValue);

        currentCell.removePiece(player.getPieces().get(0));
        nextCell.addPiece(player.getPieces().get(0));

        return board;
    }
    
}
