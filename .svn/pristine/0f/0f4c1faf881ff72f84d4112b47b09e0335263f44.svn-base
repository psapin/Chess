package pieces;


import java.awt.Color;

import board.Square;


public abstract class Piece {
	
	public int row;
	public int column;
	public Color color;
	
	public Piece(Color c, int rowLoc, int columnLoc) {
		color = c;
		row = rowLoc;
		column = columnLoc;
	}
	
	public abstract boolean canMoveTo(Square square);
	public abstract int[][] getPathTo(Square square);
	
	public Color getColor() {
		return color;
	}
	
	public void moveTo(Square square) {
		row = square.getRow();
		column = square.getColumn();
	}
	
	public boolean hasPieceOfSameColor(Square square) {
	//if there is already a piece of the same color there, not valid move
	if(square.hasPiece() && square.getPiece().getColor() == this.color)
		return true;
	return false;
	}
	
	public boolean isSameSquare(Square square) {
		if(square.getColumn() == this.column && square.getRow() == this.row)
			return true;
		return false;
	}
}
