package chess;

public class Rook extends Piece
{

  public Rook(PieceColour p)
  {
    if (p == PieceColour.WHITE){
      this.setSymbol("♖");
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♜");
    }
  }
}
