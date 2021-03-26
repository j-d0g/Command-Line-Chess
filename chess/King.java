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
		return true;
	}

}
