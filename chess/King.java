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
}
