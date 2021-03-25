package chess;

//This class requires your input
public class Square {

	private boolean hasPiece;
	private Piece p;

	public boolean hasPiece(){ //if p = null, square has no piece
		if (p == null){
			hasPiece = false;
		}
		else {
			hasPiece = true;
		}
		return hasPiece;
	}

	public void setPiece(Piece pIn){
		p = pIn;
	}

	public Piece getPiece(){
		return p;
	}
	//This method requires your input
	public void removePiece(){
		p = null;
	}
}
