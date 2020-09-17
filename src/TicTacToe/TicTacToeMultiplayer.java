/*
 * This program is a TicTacToe multiplayer game, the game board
 * is created using 2D Arrays, uses while loop to complete the game
 * making sure everyone gets the turn, uses ArrayList to keep the track
 * of the positions of the players and then prints the result if the positions 
 * matches the winning sequence or if the board if full, lets the players know 
 * its a tie game.
 */
package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class TicTacToeMultiplayer {
	//Containers to keep the track of all the positions set 
	static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
	//Stores the name of the players
	static String p1, p2;
	static Scanner sc = new Scanner(System.in);
	static char [] [] gameBoard;

	public static void main(String[] args) {
		gameBoard = new char[][] {		
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '}};

			promptNames();
			System.out.println();
			//prints the empty board to start with
			printBoard(gameBoard); 
			System.out.println();
			playGame();
	}


	//This method asks the players for their names. 
	public static void promptNames() {
		System.out.println("Welcome to the TicTacToe Game!");
		System.out.println("Please enter the name of player 1: ");
		p1 = sc.nextLine();
		System.out.println("Please enter the name of player 2: ");
		p2 = sc.nextLine();
	}

	/*
	 * This method starts the game asking the player to set the position
	 * and then checks whether it is valid or not. Then, prints the game
	 * updated game board with the symbols on it, checks whether we have 
	 * a winner or not and prints the result. 
	 */
	public static void playGame() {
		while(true) {

			System.out.println(p1 + "'s turn (X): ");
			System.out.println("Set your position from 1 - 9: ");
			int player1Pos = sc.nextInt();

			while(player1Pos <= 0 ||player1Pos > 9 || 
					player2Positions.contains(player1Pos) || player1Positions.contains(player1Pos)) {

				System.out.println("Invalid Input.\nTry again!\n");
				System.out.println(p1 + "'s turn (X): ");
				System.out.println("Set your position from 1 - 9: ");
				player1Pos = sc.nextInt();
			}

			setPosition(gameBoard, player1Pos, "Player1");
			printBoard(gameBoard);
			String result = checkWinner();
			if(result.length() > 1) {
				System.out.println(result);
				break;
			}


			//Player 2's turn
			System.out.println();
			System.out.println(p2 + "'s turn (O): ");
			System.out.println("Set your position from 1 - 9: ");
			int player2Pos = sc.nextInt();

			while(player2Pos <= 0 ||player2Pos > 9 ||
					player1Positions.contains(player2Pos) || player2Positions.contains(player2Pos)) {
				System.out.println("Invalid Input.\nTry again!\n");
				System.out.println(p2 + "'s turn (O): ");
				System.out.println("Set your position from 1 - 9: ");
				player2Pos = sc.nextInt();
			}

			setPosition(gameBoard, player2Pos, "player2");
			printBoard(gameBoard);

			result = checkWinner();
			if(result.length() > 1) {
				System.out.println(result);
				break;
			}
		}
	}

	/*
	 * This method prints the game board.
	 */
	public static void printBoard(char[][] gameBoard) {
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * This method sets the position on the game board, if the position is valid,
	 * places the appropriate symbol according to the player's turn, and then proceeds
	 * to add that position into the container that keeps the track of all the positions
	 * placed so far. 
	 */
	public static void setPosition(char[][]gameBoard, int pos, String user) {
		char symbol = ' ';
		if(user.equals("Player1")) {
			symbol = 'X';
			player1Positions.add(pos);
		} else {
			symbol = 'O';
			player2Positions.add(pos);
		}

		if(pos == 1) {
			gameBoard[0][0] = symbol;
		} else if(pos == 2) {
			gameBoard[0][2] = symbol;
		} else if(pos == 3) {
			gameBoard[0][4] = symbol;
		} else if(pos == 4) {
			gameBoard[2][0] = symbol;
		} else if(pos == 5) {
			gameBoard[2][2] = symbol;
		} else if(pos == 6) {
			gameBoard[2][4] = symbol;
		} else if(pos == 7) {
			gameBoard[4][0] = symbol;
		} else if(pos == 8) {
			gameBoard[4][2] = symbol;
		} else if(pos == 9) {
			gameBoard[4][4] = symbol;
		}
	}

	/*
	 * This method checks if we have a winner or not 
	 * by checking all the positions that p1 or p2 has
	 * set against the winning sequences, if the board 
	 * is full, a tie game. Then returns the results
	 * accordingly.
	 */
	@SuppressWarnings("rawtypes")
	public static String checkWinner() {

		List<Integer> firstRow = Arrays.asList(1, 2, 3);
		List<Integer> secondRow = Arrays.asList(4, 5, 6);
		List<Integer> thirdRow = Arrays.asList(7, 8, 9);
		List<Integer> firstCol = Arrays.asList(1, 4, 7);
		List<Integer> secondCol = Arrays.asList(2, 5, 8);
		List<Integer> thirdCol = Arrays.asList(3, 6, 9);
		List<Integer> leftDiagonal = Arrays.asList(1, 5, 9);
		List<Integer> rightDiagonal = Arrays.asList(3, 5, 7);

		List<List> winner = new ArrayList<List>();
		winner.add(firstRow);
		winner.add(secondRow);
		winner.add(thirdRow);
		winner.add(firstCol);
		winner.add(secondCol);
		winner.add(thirdCol);
		winner.add(leftDiagonal);
		winner.add(rightDiagonal);

		for(List l: winner) {
			if(player1Positions.containsAll(l)) {
				return "\nCongratulations, " + p1 + " wins.";
			} else if (player2Positions.containsAll(l)){
				return "\nCongratulations, " + p2 + " wins.";
			} 
		}
		if(player1Positions.size() + player2Positions.size() == 9) {
			return "\nTie Game!";
		}
		return " ";
	}
}