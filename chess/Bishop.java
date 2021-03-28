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

  //displayInvalidMove --Helper
  public boolean displayInvalidMove(){
    System.out.println("You can't move there.");
    return false;
  }

  @Override
  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    Piece p = Board.getPiece(i0, j0); //piece at Origin
    Piece q = Board.getPiece(i1, j1); // piece at Destination
    int iDiff = i1 - i0; //verticle displacement
    int jDiff = j1 - j0; //horizontal displacement
    boolean testSquare = false;

    if (Math.abs(iDiff) == Math.abs(jDiff)){
      for (int i = 1; i < Math.abs(iDiff); i++){ //case 6d
        //if direction is 8H -> 1A
        if (iDiff < 0 && jDiff < 0){
          testSquare = Board.hasPiece(i0-i, j0-i);
          System.out.print("iDiff: " + iDiff + "jDiff: " + jDiff + "iDiff mod: " + Math.abs(iDiff) + " i, j " + Math.abs(jDiff));
          System.out.print("i: " + i0+i + "j: " + j0+i);
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
