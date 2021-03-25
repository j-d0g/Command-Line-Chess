package chess;
import java.util.*;

public class Game
{
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play()
	{
		Scanner keyboard = new Scanner(System.in);
		final int charUnicodeA = 65;
		int intUnicode1 = 49;
		System.out.println("*** WHITE TO PLAY ***");

		while (!gameEnd){

			//User inputs piece movement, translation of input from UNICODE to ASCII
			System.out.println("Enter the piece you'd like to move:");
			String currentPosition = keyboard.next().toUpperCase();
			int j0 = (int)currentPosition.charAt(0) - charUnicodeA;
			int i0 = (int)currentPosition.charAt(1) - intUnicode1;

			System.out.println("Enter the square you'd like to move to:");
			String newPosition = keyboard.next().toUpperCase();
			int j1 = (int)newPosition.charAt(0) - charUnicodeA;
			int i1 = (int)newPosition.charAt(1) - intUnicode1;

			Piece p = Board.getPiece(i0, j0);
			Board.movePiece(i0, j0, i1, j1, p);
			Board.printBoard();

			// if (p.getColour == PieceColour.WHITE){
			// 	System.out.println("*** BLACK TO PLAY ***");
			// }
			// else if (p.getColour == PieceColour.BLACK){
			// 	System.out.println("*** WHITE TO PLAY");
			// }
		}
	}

	//This method should not be edited
	public static void main (String args[])
	{
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();
	}
}
