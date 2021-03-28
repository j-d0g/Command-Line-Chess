package chess;

public class King extends Piece {

	public King(PieceColour p){
		if (p == PieceColour.WHITE){
			this.setSymbol("♔");
			colour = PieceColour.WHITE;
		}
		else if (p == PieceColour.BLACK){
			this.setSymbol("♚");
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
		int iDiff = i1 - i0;
		int jDiff = j1 - j0;
		Piece p = Board.getPiece(i0, j0);
		Piece q = Board.getPiece(i1, j1);
		//if the king never moves more than 1 square away from origin
		if (Math.abs(iDiff) > 1 || Math.abs(jDiff) > 1){
			return displayInvalidMove();
		}
		//returns false if attempting to friendly capture
		else if (Board.hasPiece(i1, j1) && p.getColour() == q.getColour()){
			System.out.println("You can't capture your own piece!");
			return false;
		}
		return true;
	}
}
