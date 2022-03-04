package com.scaler.lld.snakesladders.services;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.snakesladders.models.Board;
import com.scaler.lld.snakesladders.models.Dice;
import com.scaler.lld.snakesladders.models.Game;
import com.scaler.lld.snakesladders.models.GameRequest;
import com.scaler.lld.snakesladders.models.Player;

public class GameService {

    List<Game> games = new ArrayList<>();

    public Game createGame(GameRequest gameRequest) {
        Game game = initialiseGame(gameRequest);
        Game persistedGame = persistGame(game);
        return persistedGame;
    }
    
    private Game initialiseGame(GameRequest gameRequest) {
        Board board = new Board(gameRequest.getBoardSize(), gameRequest.getSpecialCells());
        List<Player> players = gameRequest.getPlayers();
        List<Dice> dices = new ArrayList<>();
        return Game
                .builder()
                .board(board)
                .players(players)
                .dices(dices)
                .build();
    }

    private Game persistGame(Game game) {
        games.add(game);
        return game;
    }

}
