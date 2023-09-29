# Design Tic-Tac-Toe

## What is Tic-Tac-Toe?

TicTacToe is a 2 player game played on a 3 x 3 board. Each player is allotted a symbol (one X and one O). Initially, the board is empty. Alternatively, each player takes a turn and puts their symbol at any empty slot. The first player to get their symbol over a complete row OR a complete column OR a diagonal wins.

You can play the game within Google Search by just searching for “tictactoe”!

![TicTacToe](https://www.tuitec.com/wp-content/uploads/2016/08/morpion-640x411.jpg)


## Expectations
* The code should be working and functionally correct
* Good software design practices should be followed:
* Code should be modular, readable, extensible
* Separation of concern should be addressed
* Project structured well across multiple files/ packages
* Write unit tests
* No need of GUI


## Requirements gathering

What are some questions you would ask to gather requirements?
1 Can player be human and bot OR bot and bot OR human or human ?
2 Does player will have option to choose opposite player like if anybody want to play with human human only ?
3 who will start game randomly or option to take turn ?
4 Does user will have history of its all played games or to particular time extends ?
5 Does user can share his score to social platform ?
6 will player have undo option ?



## Requirements
What will be 10 requirements of the system, according to you?
Do not worry about the correctness of the requirements, just write down whatever comes to your mind.
Your job is not to generate the requirements, but get better at understanding problem statements and anticipating the functionalities your application might need.
1 Application should be really fast... no lag in player's move.
2 Functionality should be well define
3 Code should be maintainable and extensionable for future scope.
4 Application should follow design principals.
5 Application should be well structure in package, class functionality and behaviour.
6 Junit test cases should be properly written.
```

## Use case diagrams

Are the requirements clear enough to define use cases?
If not, try to think of the actors and their interactions with the system.

### Actors
What would be the actors in this system?
human player
bot

### Use cases

What would be the use cases i.e. the interactions between the actors and the system?

#### Actor 1
Human Player

Use cases:
```
1. Register to game
2. start game
3. Play trun(make move)
4. Make move will checkwinner() if human player is won.
```
#### Actor 2

Name of the actor - Bot
Use cases:
```
1.  play trun(make move)
2. Make move will checkwinner() if human player is won.
```

**Create a use case diagram for the system.**

```

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

## Class diagram

What will be the major classes and their attributes?

```
    Class name Game
        - Board
        - Human player
        - bot player
        ...
         Class name User(human Player)
        - Name 
        - Email Id
        - profile Image
        ...
         Class name Bot
        - Difficulty level
        ...
        Class name Cell
        - row
        - colum
        - symbol
```

List down the cardinalities of the relationships between the classes.
```

1 One game has one human player and one bot player  game-1:1-human, game 1:1 bot player
2 one game has one board game 1:1 board
3 one board has many cells 1:m
4 one user can be as many human player in game user 1 : m human player

```

Draw the class diagram.
```
```