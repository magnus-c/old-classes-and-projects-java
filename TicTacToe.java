import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to Tic-tac-toe");
		System.out.println("Enter coordinates for your move following the X and O prompts");

		while (!game.stalemate()) {
			game.print();
			System.out.print(game.getPlayer() + ":");

			// Loop while the method play does not return true when given their move.
			// Body of loop should ask for a different move
			while (!game.play(in.next())) {
				System.out.println("Illegal move. Enter your move.");
				System.out.print(game.getPlayer() + ":");
			}
			// If the game is won, call break;
			if (game.won())
				break;

			// Switch the turn
			game.switchTurn();

		}
		game.print();
		if (game.won()) {
			System.out.println("Player " + game.getPlayer() + " Wins!!!!");
		} else {
			System.out.println("Stalemate");
		}
	}

	private char[][] board;
	private char player; // 'X' or 'O'

	/*
	 * Instantiate board to be a 3 by 3 char array of spaces. Set player to be 'X'.
	 */
	public TicTacToe() {
		player = 'X';
		int n = 3;
		board = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = ' ';
			}
		}
	}
	/*
	 * If s represents a valid move, add the current player's symbol to the board
	 * and return true. Otherwise return false.
	 */

	public boolean play(String s) {
		int row = 0;
		int col = 0;
		while (true) {

			char charRow = s.charAt(0);
			if (charRow == 'A') {
				row = 0;
			} 
			else if (charRow == 'B') {
				row = 1;
			} 
			else if (charRow == 'C') {
				row = 2;
			} 
			
			col = s.charAt(1);
			
			col= col-49;//ascii starts at 48 and the array has an index of 0
			
			if(row < 0||col < 0||row > 2||col > 2) {
				return false;
			} else if(board[row][col] != ' ') {
				return false;
			} else {
				board[row][col] = player;
				return true;
			}
		}

	}

	/*
	 * Switches the current player from X to O, or O to X.
	 */
	public void switchTurn() {
		if (player == 'X') {
			player = 'O';
		} else {
			player = 'X';
		}
	}

	/*
	 * Returns true if the current player has won the game. Three in a row, column
	 * or either diagonal. Otherwise, return false.
	 */
	public boolean won() {
		for (int i = 0; i < board.length; i++) {

			boolean inARow = true;
			char value = board[i][0];
			if (value == ' ') {
				inARow = false;
			} else {
				for (int j = 1; j < board[i].length; j++) {
					if (board[i][j] != value) {
						inARow = false;
						break;
					}
				}
			}

			if (inARow) {
				return true;
			}

		}

		for (int j = 0; j < board[0].length; j++) {

			boolean inACol = true;
			char value = board[0][j];

			if (value == ' ') {
				inACol = false;

			} else {
				for (int i = 1; i < board.length; i++) {
					if (board[i][j] != value) {
						inACol = false;
						break;
					}
				}
			}

			if (inACol) {
				return true;
			}

		}

		boolean inADiag1 = true;
		char value1 = board[0][0];

		if (value1 == ' ') {
			inADiag1 = false;

		} else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != value1) {
					inADiag1 = false;
					break;
				}
			}
		}

		if (inADiag1) {
			return true;
		}

		boolean inADiag2 = true;
		char value2 = board[0][board.length - 1];

		if (value2 == ' ') {
			inADiag2 = false;

		} else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][board.length - 1 - i] != value2) {
					inADiag2 = false;
					break;
				}
			}
		}

		if (inADiag2) {
			return true;
		}

		// Otherwise nobody has not won yet
		return false;

	}

	/*
	 * Returns true if there are no places left to move
	 */
	public boolean stalemate() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public char getPlayer() {
		return player;
	}

	public void print() {
		System.out.println();
		System.out.println("\t  1 2 3");
		System.out.println();
		System.out.println("\tA " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("\t  -----");
		System.out.println("\tB " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("\t  " + "-----");
		System.out.println("\tC " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println();
	}

	/*
	 * Step 6: Main Method for Final Step - Delete your main method and uncomment
	 * this one. Runs the game by getting input from the user, making the
	 * appropriate moves, and prints who won or if it was a stalemate.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * Scanner in = new Scanner(System.in); TicTacToe game = new TicTacToe();
	 * System.out.println("Welcome to tic-tac-toe"); System.out.
	 * println("Enter coordinates for your move following the X and O prompts");
	 * 
	 * while(!game.stalemate()) { //Print the game
	 * 
	 * 
	 * //Prompt player for their move
	 * 
	 * 
	 * //Loop while the method play does not return true when given their move.
	 * //Body of loop should ask for a different move
	 * 
	 * 
	 * //If the game is won, call break;
	 * 
	 * 
	 * //Switch the turn
	 * 
	 * } game.print(); if(game.won()){
	 * System.out.println("Player "+game.getPlayer()+" Wins!!!!"); } else {
	 * System.out.println("Stalemate"); } }
	 */

}