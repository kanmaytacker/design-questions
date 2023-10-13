package com.scaler.lld.ttt.models;


import com.scaler.lld.ttt.stratergies.playing.PlayingStratergy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player{

    private GameLevel level;
    private PlayingStratergy playingStratergy;

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStratergy playingStratergy) {
        super(symbol);
        this.level = level;
        this.playingStratergy = playingStratergy;
    }

    public BotPlayer(GameSymbol symbol, GameLevel level) {
        super(symbol);
        this.level = level;
    }

    @Override
    public BoardCell makeMove(Board board) {
        return playingStratergy.makeMove(board);
    }
}
