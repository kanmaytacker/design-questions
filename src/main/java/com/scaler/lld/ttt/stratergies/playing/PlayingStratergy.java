package com.scaler.lld.ttt.stratergies.playing;

import com.scaler.lld.ttt.models.Board;
import com.scaler.lld.ttt.models.BoardCell;

public interface PlayingStratergy {

    BoardCell makeMove(Board board);
}
