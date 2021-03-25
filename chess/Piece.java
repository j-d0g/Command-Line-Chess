package chess;

//This class requires your input
public class Piece
{
	private String symbol;
	protected PieceColour colour;

	public String getSymbol()
	{
		return symbol;
	}
	public void setSymbol(String symbolIn)
	{
		symbol = symbolIn;
	}
	public PieceColour getColour(){
		return colour;
	}
}
