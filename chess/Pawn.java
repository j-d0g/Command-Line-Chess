package chess;

public class Pawn extends Piece{

	public Pawn(PieceColour p){
		if (p == PieceColour.WHITE){
			this.setSymbol("♙");
			colour = PieceColour.WHITE;
		}
		else if (p == PieceColour.BLACK){
			this.setSymbol("♟");
			colour = PieceColour.BLACK;
		}
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		//intitialize pieces
		Piece p = Board.getPiece(i0, j0);
		Piece q = Board.getPiece(i1, j1);
		int iDiff = i1-i0;
		int jDiff = j1 - j0;
		switch(p.getColour()){
			//Black to play:
			case BLACK:
				//Forward movement
				while (j0 == j1 && Board.getPiece(i1, j1) == null && Math.abs(iDiff)<=2){ //while no horizontal movement, and destination is empty
				//move forward one square
					if (i1 == i0+1){ //if movement is one squre forward
						return true;
					}
					//pawns on row 2
					while (i0 != 1){
						//move forward two squares
						if (Board.getPiece(i0+1, j1) == null && Math.abs(iDiff)<=1){ //if nothing is one square in front
							return true;
						}
					}
				}
				//Diagonal movement
				//while destination is forward diagonal and not empty
				while (((i1 == i0+1 && j1 == j0+1) || (i1 == i0+1 && j1 == j0-1)) && Board.getPiece(i1, j1) != null && (Math.abs(iDiff)<=2 && Math.abs(jDiff)<=2)){
					//returns false if attempting to friendly capture
					if (p.getColour() == q.getColour()){
						System.out.println("You can't capture your own piece!");
					}
					//returns true if diagonal enemy capture is possible
					else if (p.getColour() != q.getColour()){
						return true;
					}
				}
			break;

			//White to play:
			case WHITE:
				//Forward movement
				while (j0 == j1 && Board.getPiece(i1, j1) == null && Math.abs(iDiff)<=2){ //while no horizontal movement, and destination is empty
				//move forward one square
					if (i1 == i0-1){ //if movement is one square forward
						return true;
					}
					//pawns on row 2
					while (i0 != 6){
						//move forward two squares
						if (Board.getPiece(i0-1, j1) == null && Math.abs(iDiff)<=1){ //if nothing is one square in front
							return true;
						}
					}
				}
				//Diagonal movement
				//while destination is forward diagonal and not empty
				while (((i1 == i0-1 && j1 == j0+1) || (i1 == i0-1 && j1 == j0-1)) && Board.getPiece(i1, j1) != null){
					//returns false if attempting to friendly capture
					if (p.getColour() == q.getColour()){
						System.out.println("You can't capture your own piece!");
						return false;
					}
					//returns true if diagonal enemy capture is possible
					else if (p.getColour() != q.getColour()){
						return true;
					}
				}
		break;
		}
		// if none of these are true, move is not valid for given while conditions
		System.out.println("You can't move there.");
		return false;
	}
}
