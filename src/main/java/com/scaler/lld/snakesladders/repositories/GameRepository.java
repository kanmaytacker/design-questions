package com.scaler.lld.snakesladders.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.snakesladders.models.Game;

public class GameRepository {

    List<Game> games = new ArrayList<>();

    public Game save(Game game) {
        this.games.add(game);
        return game;
    }

    public Game findById(Integer gameId) {
        for (Game game : games) {
            if (game.getId().equals(gameId)) {
                return game;
            }
        }
        return null;
    }
}
