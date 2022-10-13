# Design Tic-Tac-Toe

## What is Tic-Tac-Toe?

TicTacToe is a 2 player game played on a 3 x 3 board. Each player is allotted a symbol (one X and one O). Initially, the board is empty. Alternatively, each player takes a turn and puts their symbol at any empty slot. The first player to get their symbol over a complete row OR a complete column OR a diagonal wins.

You can play the game within Google Search by just searching for “tictactoe”!

![TicTacToe](https://www.tuitec.com/wp-content/uploads/2016/08/morpion-640x411.jpg)


## Questions to Ask
* Will the game be played amongst only 2 players or can there be any number of players in future?
* Is the board size restricted to 3x3 or can it be any NxN?
* Can there be different ways to win?
* Can one of the players be a bot?
* Feature Suggestions:
  * Do we want to time a move? Skip/ Declare the other person as winner if the move doesn’t happen within x seconds.
  * Do we want to support undo operation?
  * Can there be some players who are just watching? Not playing.
  * Do we want to store analytics? Basically previous games, who played what move etc.
  * Support for tournaments? Basically a set of matches, each match between 2 players of the tournament.

## Expectations
* The code should be working and functionally correct
* Good software design practices should be followed:
* Code should be modular, readable, extensible
* Separation of concern should be addressed
* Project structured well across multiple files/ packages
* Write unit tests
* No need of GUI


## Problem Requirements
* Board can be of any NxN size.
* There can be two players.
* Each player will be allotted a symbol.
* The symbol can be one of O and X.
* The players can be either humans or bots.
* Each human player will have a name, email and profile image.
* Each bot player will have a difficulty level.
* Any random player can start the game.
* Then the players will take turns alternatively.
* The player with any consecutive N symbols in a row, column or diagonal wins.
* If the board is full and no player has won, the game is a draw.

## Entities and their attributes
* Game
  * Board
  * Players
* Board
  * Cells
* Cell
  * Row
  * Column
  * Symbol
* Human Player
  * Name
  * Email
  * Profile Image
* Bot Player
  * Difficulty Level

## Design 

### Use Case Diagram
```plantuml
@startuml
left to right direction
actor HumanPlayer
actor Bot
rectangle Game {
  HumanPlayer -- (Start Game)
  HumanPlayer -- (Make Move)
  Bot -- (Make Move)
    HumanPlayer -- (Register)

  (Make Move) .> (Check Winner) : includes
}

@enduml
```

### Initial Design

```mermaid
classDiagram
    class Game {
        -Board board
        -HumanPlayer humanPlayer
        -BotPlayer botPlayer
        +register(HumanPlayer) HumanPlayer
        +startGame(HumanPlayer, BotPlayer, int row, int column) Board
        +makeMove(PlayerId, int, int) Board
        +checkWinner(Board, HumanPlayer, BotPlayer) int
    }

    class Board {
        -Cell[][] cells
        +Board(int, int) : Board
    }

    class Cell {
        -int x
        -int y
        -Symbol symbol
    }

    class HumanPlayer {
        -int id
        -String name
        -String email
        -Byte[] photo
        -Symbol symbol
        +play(Board) Cell
    }

    class BotPlayer {
        -int id
        -Level level
        -Symbol symbol
        +play(Board) Cell
    }

    Game "1" --* "1" Board
    Board "1" --* "*" Cell

    Game "1" --* "1" BotPlayer
    Game "1" --* "1" HumanPlayer
```

* There is no common contract for players. Parent class to represent all different types of players.
* There is tight coupling between Game and different types of players. It is not extensible to support multiple players
* OCP and SRP violation in play method.
* Huge memory consumption - multiple instances of the player will be created for multiple games. Each instance has a new photo.

## Common contract - Player abstract class
- common behaviour - `play()`
- common attr - `symbol()`

## Tight coupling
-HumanPlayer
-BotPlayer 
-Player[] players


## OCP and SRP violation in play method - Strategy

## Huge memory consumption - Flyweight


# Version 2 with design patterns

```mermaid
classDiagram

    class ImageRegistry {
      -Map<int, Byte[]> imageMap
      +addImage(int, Byte[])
      +getImage(int) Byte[]
    }

    class Player {
      <<abstract>>
      -Int id
      -Symbol symbol
      -Byte[] image
      +play()
    }

    class HumanPlayer {
      -String name
      -String email
    }

    class BotPlayer {
      -Int level
      -PlayStrategy strategy
    }

    Player <| -- HumanPlayer
    Player <|-- BotPlayer

    class PlayStrategy {
      <<interface>>
      +bot_play()
    }

    class EasyStrategy {
      +bot_play()
    }

    class MediumStrategy {
      +bot_play()
    }

    class HardStrategy {
      +bot_play()
    }

  PlayStrategy <|-- EasyStrategy
  PlayStrategy <|-- MediumStrategy
  PlayStrategy <|-- HardStrategy

  BotPlayer "1" --o "1" PlayStrategy

    class Game {
        -Board board
        -List<Player> playerList
        -WinStrategy winStrategy
        +register(HumanPlayer) HumanPlayer
        +startGame(playerList, int row, int column) Board
        +makeMove(PlayerId, int, int) Board
        +checkWinner(Board, playerList) int
        +undo()
    }

    class WinStrategy {
      <<interface>>
      +checkWinner(Board, playerList) int
    }

    class WinStrategySimple {
      +checkWinner(Board, playerList) int
    }

    class WinStrategyComplex {
      +checkWinner(Board, playerList) int
    }

    WinStrategy <|-- WinStrategySimple
    WinStrategy <|-- WinStrategyComplex

    class Board {
        -Cell[][] cells
        +Board(int, int) : Board
    }

    class Cell {
        -int x
        -int y
        -Symbol symbol
    }

    Game "1" --* "1" Board
    Game "1" --o "1" WinStrategy
    Game "1" --* "*" Player

    Board "1" --* "*" Cell
    
```
