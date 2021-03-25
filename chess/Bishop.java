package chess;

public class Bishop extends Piece {

  public Bishop(PieceColour p){
    if (p == PieceColour.WHITE){
      this.setSymbol("♗");
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♝");
    }
  }
}
