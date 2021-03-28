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

	//displayInvalidMove --Helper
	private boolean displayInvalidMove(){
		System.out.println("You can't move there.");
		return false;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		//intitialize piece
		Piece p = Board.getPiece(i0, j0);
		Piece q = Board.getPiece(i1, j1);
		int iDiff = i1-i0;
		int jDiff = j1-j0;
		switch(p.getColour()){
			//Black to play:
			case BLACK:
				//Forward movement
				//if there's no horizontal movement, the destination is empty
				if (jDiff == 0 && !Board.hasPiece(i1, j1)){
				//if move is 1 step forward
					if (iDiff == 1){
						return true;
					}
					//If pawn is on row 2, and there is no piece in front, and the destination is 2 steps forward
					else if (i0 == 1 && !Board.hasPiece(i0+1, j1) && iDiff == 2){
						//move forward two squares
							return true;
						}
					}
				//Diagonal movement
				else if (iDiff == 1 && (jDiff == 1 || (jDiff == -1)) && Board.hasPiece(i1, j1)){
					//returns true if diagonal enemy capture is possible
					if (p.getColour() != q.getColour()){
						return true;
					}
					//returns false if attempting to friendly capture
					else if (p.getColour() == q.getColour()){
						System.out.println("You can't capture your own piece!");
					}
				}
			break;

			//White to play:
			case WHITE:
			//Forward movement
			if (jDiff == 0 && !Board.hasPiece(i1, j1)){
				if (iDiff == -1){
					return true;
				}
				//If pawn is on row 7, and there is no piece in front, and the destination is 1 step forward
				else if (i0 == 6 && !Board.hasPiece(i0-1, j1) && iDiff== -2){
					//move forward two squares
					return true;
					}
				}
			//Diagonal movement
			else if (iDiff == -1 && (jDiff == 1 || (jDiff == -1)) && Board.hasPiece(i1, j1)){
				if (p.getColour() != q.getColour()){
					return true;
				}
				//returns false if attempting to friendly capture
				else if (p.getColour() == q.getColour()){
					System.out.println("You can't capture your own piece!");
				}
			}
		break;
		}
		// if none of the above are true, move is not valid for given while conditions
		return displayInvalidMove();
	}
}
