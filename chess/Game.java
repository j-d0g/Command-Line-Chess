package chess;
import java.util.*;

public class Game
{
	private static boolean gameEnd=false;

	//Helper Method
	private static String inputCoordinates(){
		Scanner keyboardString = new Scanner(System.in);
		String coordinates = keyboardString.next().toUpperCase();
		while (!coordinates.matches("[1-8][a-hA-H]")){
			System.out.println("Invalid entry. Entry must be in the range [1-8][a-h]");
			coordinates = keyboardString.next().toUpperCase();
		}
			return coordinates;
	}

	//Turn Management // Origin Validation --Helper
	private static boolean isValid(int i0In, int j0In, boolean blackToPlayIn){
			if (Board.getPiece(i0In, j0In) == null){
				 System.out.println("Square is empty");
			}
			else if (blackToPlayIn && Board.getPiece(i0In, j0In).getColour() != PieceColour.BLACK){
				System.out.println("Invalid Square: Black to move.");
			}
			else if (!blackToPlayIn && Board.getPiece(i0In, j0In).getColour() != PieceColour.WHITE){
				System.out.println("Invalid Square: White to move.");
			}
			else {
				return true;
			}
			return false;
		}

	//Prints Turn --Helper
	private static boolean displayTurn(Piece pIn){
		if(pIn.getColour() == PieceColour.WHITE){
			System.out.println("*** BLACK TO PLAY ***");
			return true;
		}
		else {
			System.out.println("*** WHITE TO PLAY ***");
			return false;
		}
	}


	//This method requires your input
	public static void play()
	{
		Scanner keyboardString = new Scanner(System.in);
		final int charUnicodeA = 65; //used to translate unicode characters a-zA-Z's ASCII values to index value
		final int intUnicode1 = 49; //used to translate unicode characters 1-8's ASCII values to index value
		boolean blackToPlay = false;
		Piece p;
		int i0, j0, i1, j1;
		System.out.println("*** WHITE TO PLAY ***");

		while (!gameEnd){

			//User inputs origin
			System.out.println("Enter origin:");
			do {
				String origin = inputCoordinates();
				i0 = (int)origin.charAt(0) - intUnicode1;
				j0 = (int)origin.charAt(1) - charUnicodeA;
				p = Board.getPiece(i0, j0);
			} while(!isValid(i0, j0, blackToPlay));


			//User inputs destination
			System.out.println("Enter destination");
			String destination = inputCoordinates();
			i1 = (int)destination.charAt(0) - intUnicode1;
			j1 = (int)destination.charAt(1) - charUnicodeA;
			Piece q = Board.getPiece(i1, j1);

			//Implement changes
			Board.movePiece(i0, j0, i1, j1, p);
			Board.printBoard();
			blackToPlay = displayTurn(p);
		}
	}

	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();
	}
}

/*
//Helper method
private static boolean displayTurn(PieceColour lastTurnIn){
	if(lastTurnIn == PieceColour.WHITE){
		System.out.println("*** BLACK TO PLAY ***");
		return true;
	}
	else {
		System.out.println("*** WHITE TO PLAY ***");
		return false;
	}
}
*/
