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

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		if (Math.abs(iDiff) == 1 && Math.abs(jDiff) == 1){
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
		return true;
	}

}
