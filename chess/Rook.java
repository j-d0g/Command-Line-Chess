package chess;

public class Rook extends Piece
{

  public Rook(PieceColour p)
  {
    if (p == PieceColour.WHITE){
      this.setSymbol("♖");
      colour = PieceColour.WHITE;
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♜");
      colour = PieceColour.BLACK;
    }
  }
}
