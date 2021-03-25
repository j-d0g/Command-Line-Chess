package chess;

public class Pawn extends Piece
{

	public Pawn(PieceColour p){
		if (p == PieceColour.WHITE){
			this.setSymbol("♙");
		}
		else if (p == PieceColour.BLACK){
			this.setSymbol("♟");
		}
	}
}
