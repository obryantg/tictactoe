package tictactoeGame;

import java.util.Scanner;

public class runGame {
	public static void main(String[] args){
		
		char[][] board = new char [3][3];
		char player = 'x';
		char opponent = 'o';
		int rowX = 0;
		int colX = 0;
		int rowO = 0;
		int colO = 0;
		
		String reply="yes";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Lets play tic tac toe");
		System.out.println();
		
		
			
		while (reply.equalsIgnoreCase("yes")){
			boolean youWin = true;
			setBoard(board);
			getLayout(board);
		
		while (youWin == true){
		System.out.println("Player 1 - Enter row, then column number"
				+ " between 0 and 2:");
			rowX = sc.nextInt();
			colX = sc.nextInt();
			board[rowX][colX] = player;
			getLayout(board);
			
			
		if (playerWins(board, player)){
			youWin = false;
			System.out.println("Player 1 wins!");
			break;
			
		}	 else if (tieGame(board)){
			youWin = false;
			System.out.println("Game is a tie!");
			break;
		}
		
		System.out.println("Player 2 - Enter row, then column number"
				+ " between 0 and 2:");
			rowO = sc.nextInt();
			colO = sc.nextInt();
			board[rowO][colO] = opponent;
			getLayout(board);

			if (playerWins(board, opponent)){
				youWin = false;
				System.out.println("Opponent wins!");
				break;
				
				
			} else if (tieGame(board) ){
				youWin = false;
				System.out.println("Game is a tie!");
				break;
			}
			
	}System.out.println("Play again? Enter 'yes' or 'no':");
	reply = sc.next();
	
    
	} sc.close();
	}

	private static boolean tieGame(char[][] board) {
		//looks to see if board is full; returns tie game
		return board[0][0] != '-' && board[0][1] != '-' &&
				board[0][2] != '-' && board[1][0] != '-' &&
				board[1][1] != '-' && board[1][2] != '-' &&
				board[2][0] != '-' && board[2][1] != '-' &&
				board[2][2] != '-';
	}

	private static boolean playerWins(char[][] board, char player) {
		//checks to see if any player won..
		return board[0][0]==player && board[0][1]==player && board[0][2]==player
			|| board[1][0]==player && board[1][1]==player && board[1][2]==player
			|| board[2][0]==player && board[2][1]==player && board[2][2]==player
			|| board[0][0]==player && board[1][0]==player && board[2][0]==player
			|| board[0][1]==player && board[1][1]==player && board[2][1]==player
			|| board[0][2]==player && board[1][2]==player && board[2][2]==player
			|| board[0][0]==player && board[1][1]==player && board[2][2]==player
			|| board[2][0]==player && board[1][1]==player && board[0][2]==player;
	}

	private static void getLayout(char[][] board) {
		//makes the layout/grid for the board
		System.out.println("   0   1   2  ");
		System.out.println(" -------------");
		for (int a=0; a < board.length; a++){
			System.out.print(a + "| ");
			for (int b=0; b < board.length; b++){
				System.out.print(board[a][b] +  " | ");
			}System.out.println();
			System.out.println(" -------------");
			
		}
	}

	private static void setBoard(char[][] board) {
		// sets char for resetting board/ value for tieGame.
		for (int a=0; a < 3; a++){
			for (int b=0; b < 3; b++){
				board [a][b] = '-';
			}
		}
	}
}
