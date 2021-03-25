package chess;

public class Queen extends Piece
{
  public Queen(PieceColour p)
  {
    if (p == PieceColour.WHITE){
      this.setSymbol("♕");
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♛");
    }
  }
}
