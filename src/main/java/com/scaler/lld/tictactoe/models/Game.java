package com.scaler.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.tictactoe.strategies.WinningStrategy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    
    private Board board;
    private List<Player> players = new ArrayList<>();
    private WinningStrategy strategy;
}
