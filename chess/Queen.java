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

  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    Piece p = Board.getPiece(i0, j0); //piece at Origin
    Piece q = Board.getPiece(i1, j1); // piece at Destination
    Piece r;
    int iDiff = i1 - i0; //verticle displacement
    int jDiff = j1 - j0; //horizontal displacement
    // <---> horizontal movement
    if (iDiff == 0){
      //inspects each square between origin and destination
      for (int i = 1; i < Math.abs(jDiff); i++){
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
    //1A to 8H diagonal
    else if (iDiff == jDiff){
      //inspects each square between origin and destination
      for (int i = 1; i < Math.abs(iDiff); i++){
        //if move is in direction 8H -> 1A
        if (iDiff < 0){
          r = Board.getPiece(i0+i, j0+i);
        }
        //if move is in direction 8H <- 1A
        else if (iDiff > 0){
          r = Board.getPiece(i0-i, j0-i);
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
    //1A to 8H diagonal
    else if (iDiff == -jDiff){
      //inspects each square between origin and destination
      for (int i = 1; i < Math.abs(iDiff); i++){
        //if move is in direction 8A -> 1H
        if (iDiff < 0){
          r = Board.getPiece(i0-i, j0+i);
        }
        //if move is in direction 8A <- 1H
        else if (iDiff > 0){
          r = Board.getPiece(i0+i, j0-i);
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
    else if ((iDiff != jDiff) && (iDiff != 0 && jDiff != 0)){
      return displayInvalidMove();
    }
    return true;
  }

}
