package chess;


//This class is partially implemented
public class Board{
	private static Square [][] board = new Square[8][8];

	//This method should not be edited
	public static void initialiseBoard(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square();
		}
	}

	//This method requires your input
	public static void initialisePieces()
	{
		//White pieces
		Board.setPiece(6,0,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,1,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,2,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,3,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,4,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,5,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,6,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,7,new Pawn(PieceColour.WHITE));
		Board.setPiece(7,0,new Rook(PieceColour.WHITE));
		Board.setPiece(7,1,new Knight(PieceColour.WHITE));
		Board.setPiece(7,2,new Bishop(PieceColour.WHITE));
		Board.setPiece(7,3,new Queen(PieceColour.WHITE));
		Board.setPiece(7,4,new King(PieceColour.WHITE));
		Board.setPiece(7,5,new Bishop(PieceColour.WHITE));
		Board.setPiece(7,6,new Knight(PieceColour.WHITE));
		Board.setPiece(7,7,new Rook(PieceColour.WHITE));
		//Black Pieces
		Board.setPiece(0,0,new Rook(PieceColour.BLACK));
		Board.setPiece(0,1,new Knight(PieceColour.BLACK));
		Board.setPiece(0,2,new Bishop(PieceColour.BLACK));
		Board.setPiece(0,3,new Queen(PieceColour.BLACK));
		Board.setPiece(0,4,new King(PieceColour.BLACK));
		Board.setPiece(0,5,new Bishop(PieceColour.BLACK));
		Board.setPiece(0,6,new Knight(PieceColour.BLACK));
		Board.setPiece(0,7,new Rook(PieceColour.BLACK));
		Board.setPiece(1,0,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,1,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,2,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,3,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,4,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,5,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,6,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,7,new Pawn(PieceColour.BLACK));
	}

	//This method requires your input
	public static void printBoard()
	{
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		for (int i=0; i<board[0].length; i++) //iterating rows
		{
			int row=i+1; //translates index to row number
				for (int j=0; j<board[1].length; j++){ //iterating columns
					if ((j==0) && Board.hasPiece(i,j)) //if we're on column a, and the board has a piece at the position i, j
						System.out.print(row+" "+Board.getPiece(i,j).getSymbol()); //print the row number, followed by whitespace followed by the symbol of the piece at position i, j
					else if ((j==0) && !Board.hasPiece(i,j)) //else if we're on column a and the board has no piece at coordinate i, j
						System.out.print(row+"  " ); //print row number, followed by whitespace
					else if (Board.hasPiece(i,j)) //else if the board has a piece at position i, j and we're not on column a
						System.out.print("|"+Board.getPiece(i,j).getSymbol()); //print | followed by the symbol of the piece at position i, j
					else //if none of the conditions above satisfy, meaning we're not on column a and we're not in a and there's no piece at i, j
						System.out.print("| "); //print "| "
				}
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");
	}

	//This method requires your input
	public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p)
	{
		//Purely logic for now, as I need to figure out what enum does

		/*
		if (p.getColour() == PieceColour.WHITE && p.getSymbol != "♔" && getPiece(i1, j1).getSymbol() == "♚"){
			return true;
		}
		else if (p.getColour() == PieceColour.BLACK && p.getSymbol != "♚" && getPiece(i1, j1).getSymbol() == "♔"){
			return true;
		}
		else if (p.getColour() == getPiece(i1, j1).getColour){ //prevents capturing your own piece, but ideally implemented in play() if possible
			return false;
		}
		*/
		board[i0][j0].removePiece();
		board[i1][j1].removePiece();
		Board.setPiece(i1, j1, p);
			return false;
	}

	//This method requires your input
	public static void setPiece(int iIn, int jIn, Piece p)
	{
		board[iIn][jIn].setPiece(p);
	}

	//This method requires your input
	public static Piece getPiece(int iIn, int jIn)
	{
		return board[iIn][jIn].getPiece();
	}

	//This method requires your input
	public static boolean hasPiece(int i, int j)
	{
		return board[i][j].hasPiece();
		// return true;
	}

}
