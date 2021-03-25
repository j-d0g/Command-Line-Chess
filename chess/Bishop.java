package chess;

public class Bishop extends Piece {

  public Bishop(PieceColour p){
    if (p == PieceColour.WHITE){
      this.setSymbol("♗");
      colour = PieceColour.WHITE;
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♝");
      colour = PieceColour.BLACK;
    }
  }
}
