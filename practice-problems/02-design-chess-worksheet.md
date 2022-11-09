# Design Chess

- [Design Chess](#design-chess)
  - [Overview](#overview)
  - [Expectations](#expectations)
  - [Requirements gathering](#requirements-gathering)
  - [Requirements](#requirements)
  - [Use case diagrams](#use-case-diagrams)
    - [Actors](#actors)
    - [Use cases](#use-cases)
      - [Actor 1](#actor-1)
      - [Actor 2](#actor-2)
      - [Actor 3](#actor-3)
  - [Class diagram](#class-diagram)
  - [API design](#api-design)

## Overview

Chess is a two-player game played on a chessboard, a checkered game board with `64 squares` arranged in an `8 x 8` grid. Each player begins the game with `16 pieces` consisting of:
* One king
* One queen
* Two rooks
* Two bishops
* Two knights
* Eight pawns

Each of the six piece types moves differently, with the most powerful being the queen and the least powerful being the pawn. The objective is to `checkmate` the opponent's king by placing it under an inescapable threat of capture. To this end, a player's pieces are used to attack and capture the opponent's pieces, while supporting each other.

There are many variants of chess, but we will be focusing on the standard two-player game.

![Chess Board](https://www.chess.com/bundles/web/images/offline-play/standardboard.png)

**Pieces and their moves:**
* `King`: Key entity in chess. If your king is killed then you lose. Its also called checkmate.
* `Queen`: It can move any number of steps in a single move and in any direction.
* `Rook`: It only moves in horizontal and vertical direction but can move any number of steps in single move.
* `Bishop`: It only moves in diagonal direction but can move any number of steps in single move.
* `Knight`: It makes L shaped moves. Check online for more details about it.
* `Pawn`: It can move 1 step forward vertically. If it is its first turn, then it can also choose to make 2 steps in single move.  
Note: All pieces except Knight cannot jump any other piece. Knight can jump over other pieces.

## Expectations
* Code should be functionally correct.
* Code should be modular and readable. Clean and professional level code.
* Code should be extensible and scalable. Means it should be able to accommodate new requirements with minimal changes.
* Code should have good OOP design principles.

## Requirements gathering

What are some questions you would ask to gather requirements?

```
```

## Requirements
What will be 10 requirements of the system, according to you?
Do not worry about the correctness of the requirements, just write down whatever comes to your mind.
Your job is not to generate the requirements, but get better at understanding problem statements and anticipating the functionalities your application might need.
```
```

<details>
  <summary><strong>Click to see the actual requirements</strong></summary>
  
  1. The system should support two online players to play a game of chess.
  2. All rules of international chess will be followed.
  3. Each player will be randomly assigned a side, black or white.
  4. Both players will play their moves one after the other. The white side plays the first move.
  5. Players can’t cancel or roll back their moves.
  6. The system should maintain a log of all moves by both players.
  7. Each side will start with 8 pawns, 2 rooks, 2 bishops, 2 knights, 1 queen, and 1 king.
  8. The game can finish either in a checkmate from one side, forfeit or stalemate (a draw), or resignation.
</details>

## Use case diagrams

Are the requirements clear enough to define use cases?
If not, try to think of the actors and their interactions with the system.

### Actors
What would be the actors in this system?
```
```

### Use cases

What would be the use cases i.e. the interactions between the actors and the system?

#### Actor 1

Name of the actor - ` `

Use cases:
```
1. 
2. 
3. 
4. 
```
#### Actor 2

Name of the actor - ` `
Use cases:
```
1. 
2. 
3. 
4. 
```

#### Actor 3

Name of the actor - ` `
Use cases:
```
1. 
2. 
3. 
4. 
```
Add more actors and their use cases as needed.

**Create a use case diagram for the system.**

```
```

## Class diagram

What will be the major classes and their attributes?

```
    Class name
        - Attribute 1
        - Attribute 2
        ...
```

List down the cardinalities of the relationships between the classes.
```
```

Draw the class diagram.
```
```

## API design

What will be some APIs that you would design for this system?

Look at the use cases and try to design APIs for each of them.

You can simply write the APIs in the following format:
`API name` - `HTTP method` - `URL` - `?Request body` - `?Response body`

You could also use a tool like [Swagger](https://swagger.io/) to design the APIs or follow [this](https://github.com/jamescooke/restapidocs) repository for a simple way to use Markdown to structure your API documentation.

```
```
