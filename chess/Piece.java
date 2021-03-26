package chess;

//This class requires your input
public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol(){
		return symbol;
	}
	public void setSymbol(String symbolIn){
		symbol = symbolIn;
	}
	public PieceColour getColour(){
		return colour;
	}

	public abstract boolean isLegitMove(int i0In, int j0In, int i1In, int j1In);
}
