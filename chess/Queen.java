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
  public boolean displayInvalidMove(){
    System.out.println("You can't move there.");
    return false;
  }

  public int isBigger(int iDiffIn, int jDiffIn){
    if (iDiffIn > jDiffIn){
      return iDiffIn;
    }
    return jDiffIn;
  }

  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    Piece p = Board.getPiece(i0, j0); //piece at Origin
    Piece q = Board.getPiece(i1, j1); // piece at Destination
    Piece r;
    int iDiff = i1 - i0; //verticle displacement
    int jDiff = j1 - j0; //horizontal displacement
    boolean testSquare = false;

    // for (int i=1; i<Math.abs(isBigger(iDiff, jDiff); i++){
    //   if (iDiff == 0 && jDiff > 0){
    //
    //   }
    // }
    // <---> horizontal movement
    if (iDiff == 0){
      //inspects each square between origin and destination
      for (int i=1; i<Math.abs(jDiff); i++){
        // <---
        if (jDiff < 0){
          r = Board.getPiece(i0, j0-i);
        }
        // --->
        else if (jDiff > 0){
          r = Board.getPiece(i0, j0+i);
        }
        //if no movement
        else{
          return displayInvalidMove();
        }
          if (r != null){ //if current square reviewed contains a piece)
            return displayInvalidMove();
          }
        }
      if (q != null && p.getColour() == q.getColour()){ //prevents friendly capture
          System.out.println("You can't capture your own piece!");
          return false;
      }
    }
    //verticle movement
    else if (jDiff == 0){
      //inspects each square between origin and destination
      for (int i = 1; i < Math.abs(iDiff); i++){
        //move up the board
        if (iDiff < 0){
          r = Board.getPiece(i0-i, j0);
        }
        //move down the board
        else if (iDiff > 0){
          r = Board.getPiece(i0+i, j0);
        }
        //if no movement
        else{
          return displayInvalidMove();
        }
          if (r != null){ //if current square reviewed contains a piece)
            return displayInvalidMove();
          }
        }
      if (q != null && p.getColour() == q.getColour()){ //prevents friendly capture
          System.out.println("You can't capture your own piece!");
          return false;
      }
    }

    //Diagonal Movement
    if (Math.abs(iDiff) == Math.abs(jDiff)){
      for (int i = 1; i < Math.abs(iDiff); i++){ //case 6d
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
    if (Math.abs(iDiff) != Math.abs(jDiff)){
      return displayInvalidMove();
    }
    return true;
  }
}
