package chess;

public class Knight extends Piece {

  //displayInvalidMove --Helper
	private boolean displayInvalidMove(){
		System.out.println("You can't move there.");
		return false;
	}

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

  @Override
  public boolean isLegitMove(int i0, int j0, int i1, int j1){

    int iDiff = i1 - i0;
    int jDiff = j1 - j0;
    int iSize = Math.abs(iDiff);
    int jSize = Math.abs(jDiff);
    int ijTotal = iSize + jSize;
    Piece p = Board.getPiece(i0, j0);
    Piece q = Board.getPiece(i1, j1);

    if ((iSize == 2 || jSize == 2) && ijTotal == 3){
      if (Board.hasPiece(i1, j1) && p.getColour() == q.getColour()){
        System.out.println("You can't capture your own piece!");
        return false;
      }
      else{
        return true;
      }
    }
    return displayInvalidMove();
  }
}
