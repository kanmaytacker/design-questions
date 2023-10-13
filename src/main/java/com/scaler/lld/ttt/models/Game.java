package com.scaler.lld.ttt.models;

import com.scaler.lld.ttt.TicTacToe;
import com.scaler.lld.ttt.exception.InvalidMoveException;
import com.scaler.lld.ttt.exception.InvalidPlayersException;
import com.scaler.lld.ttt.stratergies.winning.ColumnWinningStratergy;
import com.scaler.lld.ttt.stratergies.winning.DiagnolWinningStratergy;
import com.scaler.lld.ttt.stratergies.winning.RowWinningStratergy;
import com.scaler.lld.ttt.stratergies.winning.WinningStratergy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {
    private static final int PLAYER_COUNT = 2;
    private Board board;
    private List<Player> players = new ArrayList<>();

    private GameStatus status;
    private int nextPlayerIndex = 0;
    private Player winner;
    private List<WinningStratergy> winningStratergies = List.of(new RowWinningStratergy(), new ColumnWinningStratergy(), new DiagnolWinningStratergy());

    private Game(){

    }

    public void start(){
        //Assign a random value to the nextPlayerIndex
        //Random value between 0 to 1;
        nextPlayerIndex = (int) (Math.random() * players.size());
        //set status to IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
    }

    public void makeMove(){
        //get the next player

        BoardCell move = getNextMove();
        //update the board
        board.update(move);

        //check for win or draw
        if(checkWinner(move.getSymbol())){
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }
        if(checkDraw()){
            status = GameStatus.DRAWN;
            return;
        }
        //update the player to next player
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private BoardCell getNextMove() {
        //get the move from player
        //makeMove
        //Bot - playing stratergy
        //human - get input from Scanner
        Player player = players.get(nextPlayerIndex);
        BoardCell move = player.makeMove(board);
        //validate user move if the cell is already filled or not
        validateMove(move);
        move.setSymbol(player.getSymbol());
        return move;
    }

    private void validateMove(BoardCell move) {
        boolean isEmpty = board.isEmpty(move.getRow(), move.getCol());
        if(!isEmpty){
            throw new InvalidMoveException(move.getRow(), move.getCol());
        }
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    private boolean checkWinner(GameSymbol currentSymbol){
        //Implement check rows winner
        for(WinningStratergy stratergy: winningStratergies){
            if(stratergy.checkWinner(getBoard(), currentSymbol)){
                return true;
            }
        }
        //assignment check col and diagnol winner
        return false;
    }

    private boolean checkRows(GameSymbol currentSymbol) {
        for(List<BoardCell> rows: board.getCells()){

            for(BoardCell cell : rows){
                if(cell.getSymbol() != currentSymbol){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDraw(){
        return getStatus() == GameStatus.IN_PROGRESS
                && getBoard().getEmptyCells().isEmpty();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Game game;

        private  Builder(){
            game = new Game();
        }

        public Builder withSize(int size){
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player){
            game.players.add(player);
            return this;
        }

        public Game build(){
            boolean isValid = validate();
            if(!isValid){
                throw new InvalidPlayersException();
            }
            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = GameStatus.IN_PROGRESS;
            return newGame;
        }

        private boolean validate() {
            if(game.players.size() != PLAYER_COUNT){
                return false;
            }
            Set<GameSymbol> symbols = game.players.stream().map(
                    Player::getSymbol
            ).collect(Collectors.toSet());
            return symbols.size() == PLAYER_COUNT;
        }
    }
}
