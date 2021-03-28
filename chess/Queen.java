package chess;

public class Queen extends Piece{
  public Queen(PieceColour p){
    if (p == PieceColour.WHITE){
      this.setSymbol("♕");
      colour = PieceColour.WHITE;
    }
    else if (p == PieceColour.BLACK){
      this.setSymbol("♛");
      colour = PieceColour.BLACK;
    }
  }

  //displayInvalidMove --Helper
  private boolean displayInvalidMove(){
    System.out.println("You can't move there.");
    return false;
  }

  public int isBigger(int iDiffIn, int jDiffIn){
    int iSize = Math.abs(iDiffIn);
    int jSize = Math.abs(jDiffIn);
    if (iSize > jSize){
      return iSize;
    }
    return jSize;
  }

  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    Piece p = Board.getPiece(i0, j0); //piece at Origin
    Piece q = Board.getPiece(i1, j1); // piece at Destination
    Piece r;
    int iDiff = i1 - i0; //verticle displacement
    int jDiff = j1 - j0; //horizontal displacement
    boolean testSquare = false;

    //Verticle movement
    if (iDiff == 0 || jDiff == 0){
      for (int i = 1; i < Math.abs(isBigger(iDiff, jDiff)); i++){
        // 1 --> 8
        if (iDiff > 0){
          testSquare = Board.hasPiece(i0+i, j0);
        }
        // 1 <-- 8
        else if (iDiff < 0) {
          testSquare = Board.hasPiece(i0-i, j0);
        }
        // A --> H
        else if (jDiff > 0) {
          testSquare = Board.hasPiece(i0, j0+i);
        }
        // A <-- H
        else if (jDiff < 0) {
          testSquare = Board.hasPiece(i0, j0-i);
        }
        //if testSquare contains piece
        if (testSquare){
          return displayInvalidMove();
        }
      }
      if (Board.hasPiece(i1, j1) && p.getColour() == q.getColour()){
        System.out.println("You can't capture your own piece!");
        return false;
      }
    }
    //Diagonal Movement
    else if (Math.abs(iDiff) == Math.abs(jDiff)){
      for (int i = 1; i < Math.abs(iDiff); i++){
        //if direction is 8H -> 1A
        if (iDiff < 0 && jDiff < 0){
          testSquare = Board.hasPiece(i0-i, j0-i);
        }
        //if direction is 8H <- 1A
        else if (iDiff > 0 && jDiff > 0){
          testSquare = Board.hasPiece(i0+i, j0+i);
        }
        //if direction is 8A -> 1H
        else if (iDiff > 0 && jDiff < 0){
          testSquare = Board.hasPiece(i0+i, j0-i);
        }
        //if direction is 8A <- 1H
        else if (iDiff < 0 && jDiff > 0){
          testSquare = Board.hasPiece(i0-i, j0+i);
        }
        if (testSquare){
          return displayInvalidMove();
        }
      }
      if (Board.hasPiece(i1, j1) && p.getColour() == q.getColour()){
        System.out.println("You can't capture your own piece!");
        return false;
      }
    }
    if ((Math.abs(iDiff) != Math.abs(jDiff)) && (iDiff != 0 && jDiff != 0)){
      return displayInvalidMove();
    }
    return true;
  }
}
