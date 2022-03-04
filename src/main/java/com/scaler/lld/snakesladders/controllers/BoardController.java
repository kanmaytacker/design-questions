package com.scaler.lld.snakesladders.controllers;

import com.scaler.lld.snakesladders.models.Board;
import com.scaler.lld.snakesladders.services.BoardService;

public class BoardController {
    
    private BoardService boardService = new BoardService();

    public Board makeMove(Integer gameId, Integer playerId) {
        return boardService.makeMove(gameId, playerId);
    }
}
