package chess;

public class Queen extends Piece
{
  public Queen(PieceColour p)
  {
    if (p == PieceColour.WHITE){
      this.setSymbol("♕");
      colour = PieceColour.WHITE;
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♛");
      colour = PieceColour.BLACK;
    }
  }
}
