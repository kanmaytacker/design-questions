# Implementing Tic Tac Toe

We have successfully designed Tic Tac Toe. Now, it's time to implement it.
A thorough design removes a lot of confusion and makes implementation easier.
However, implementation is not a piece of cake. It requires a lot of effort and may require you to make small adjustments to your design.

This is why it helps to list down the steps that you need to follow to implement the design.

## Steps to implement Tic Tac Toe

1. `Models` - The easiest part of the implementation. You just need to create the models and their relationships from the class diagram.

!!! note You can find the class diagram [here](../../../../../../../notes/02-design-tic-tac-toe.md#complete-class-diagram).

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/tree/xo-models/src/main/java/com/scaler/lld/tictactoe/models">Models</a>
</details>

---

2. `Make Move` - Probably, the most important method in the implementation. Start from [here](https://github.com/kanmaytacker/design-questions/blob/xo-models/src/main/java/com/scaler/lld/tictactoe/models/Game.java#L26). You will find comments to guide your way. Mock whatever is necessary.

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/xo-make-move/src/main/java/com/scaler/lld/tictactoe/models/Game.java#L26">Make Move</a>
</details>

---

3. `Random Playing Bot` - Let us implement a basic bot which randomly plays the game. This will help us test our implementation. Again, fill in the blanks [here](https://github.com/kanmaytacker/design-questions/blob/xo-make-move/src/main/java/com/scaler/lld/tictactoe/strategies/RandomPlayingStrategy.java).

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/xo-random-bot-playing/src/main/java/com/scaler/lld/tictactoe/strategies/RandomPlayingStrategy.java">Random Playing Bot</a>
</details>

!!! danger When you are writing so much code, it is dangerous to leave code untested. Try to write some test cases along the way. For instance, your strategy can be easily tested.

If you are stuck, the latter has already been implemented for you in the above solution branch.

---

4. `Check winner and draw` - Now, we need to check if the game has ended. We need to check if there is a winner or if the game has ended in a draw. This is a little tricky. You need to check if the game has ended after every move. Try to implement just a basic winner check like consecutive 3 symbols on the same row or column. You can add more logic later.

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/xo-check-column-winner/src/main/java/com/scaler/lld/tictactoe/models/Game.java#L60">Check winner and draw</a>
</details>

---
6. `Print the board` - Visualising the board is important. Implement a method to print the board. You can use the following format -

```
| - | - | - |
| - | - | - |
| O | - | X |
```
<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/xo-check-column-winner/src/main/java/com/scaler/lld/tictactoe/TicTactToe.java">Print the board</a>
</details>

---
7. `Game Controller` - Implement a main class that simulates the real game. Things you have to do -
   1. Create an instance of the game
   2. Run the game until a winner or draw
   3. On each turn, trigger a move
   4. Print the board after every move
   5. At the end, print if there is a winner or a draw

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/xo-check-column-winner/src/main/java/com/scaler/lld/tictactoe/TicTactToe.java">Game Controller</a>
</details>

---
**Assignment**

Use strategy design pattern to abstract away different winning conditions like
1. Row
2. Column
3. Diagonal

Think about how to use them together.