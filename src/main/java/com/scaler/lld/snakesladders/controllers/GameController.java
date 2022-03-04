package com.scaler.lld.snakesladders.controllers;

import com.scaler.lld.snakesladders.models.Game;
import com.scaler.lld.snakesladders.models.GameRequest;
import com.scaler.lld.snakesladders.services.GameService;

public class GameController {
    
    private GameService gameService = new GameService();

    public Game createGame(GameRequest gameRequest) {
        return gameService.createGame(gameRequest);
    }
    
}
