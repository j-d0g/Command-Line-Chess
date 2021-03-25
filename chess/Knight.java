package chess;

public class Knight extends Piece
{

  public Knight(PieceColour p){
    if (p == PieceColour.WHITE){
      this.setSymbol("♘");
      colour = PieceColour.WHITE;
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♞");
      colour = PieceColour.BLACK;
    }
  }
}
