package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.strategies.PlayingStrategy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {

    private PlayingStrategy playingStrategy;

    @Override
    public BoardCell play(Board board) {
        // TODO Auto-generated method stub
        return null;
    }

}
