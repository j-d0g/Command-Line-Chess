package chess;

public class Knight extends Piece
{

  public Knight(PieceColour p){
    if (p == PieceColour.WHITE){
      this.setSymbol("♘");
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♞");
    }
  }
}
