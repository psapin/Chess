package board;
import java.awt.Color;

import pieces.Piece;


public class Square {
	
	private Piece piece;
	private Color color;
	private int row;
	private int column;
	private boolean validSpace;
	
	public Square(int rowNum, int columnNum, Color c, boolean valid) {
		row = rowNum;
		column = columnNum;
		color = c;
		validSpace = valid;
		piece = null;
	}
	
	public Square(int rowNum, int columnNum, Color c, Piece boardPiece){
		row = rowNum;
		column = columnNum;
		color = c;
		validSpace = true;
		piece = boardPiece;
	}
	
	public boolean hasPiece() {
		return piece != null;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece boardPiece) {
		piece = boardPiece;
	}
	
	/**
	 * @return the validSpace
	 */
	public boolean isValidSpace() {
		return validSpace;
	}

	/**
	 * @param validSpace set whether square is valid
	 */
	public void setValidSpace(boolean validSpace) {
		this.validSpace = validSpace;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	
}
