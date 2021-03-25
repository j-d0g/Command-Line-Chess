package chess;

public class Pawn extends Piece
{

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
}
