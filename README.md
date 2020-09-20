# TicTacToe
This is a TicTacToe mutliplayer game.

# Instructions
Enter the name of the players. Player1 is X and player2 is O. Then, set the positions on the board from 1 - 9 according to your turn. If either one of the players have a winning
sequence on the board, it will display the result. If none of the player wins, message saying that it is a tie-game is displayed. 

# How it works
The game board is created using 2D Array, prints the board using for loop. 'X' symbol is assigned to player1 to represent the turn on the board, 'O' symbol is for the player2
which differntiates it from the player1 on the board. The switch case is used to place the symbols on the game board. Every time a position is set on the board, it gets stored 
in ArrayList to keep the track of the positions, so that the other player doesn't overlaps the position that is already set. Winning sequences are stored as list and are compared
to the container to check if we have a winner or if player1's arraylist + player2's arraylist which has all their positions set on the board already, is equal to 9, then the board
is full and its a tie-game.
