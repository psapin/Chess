package pieces;

import java.awt.Color;

import board.Square;


public class Queen extends Piece {

	public Queen(Color c, int xLoc, int yLoc){
		super(c, xLoc, yLoc);
	}
	
	@Override
	public
	boolean canMoveTo(Square square) {
		//if no movement, not valid move
		if(isSameSquare(square))
			return false;
		// if not bishop-like movement, check rook-like movement
		if(Math.abs(square.getRow() - row) != Math.abs(square.getColumn() - column)) {
			if(square.getRow() != this.row && square.getColumn() != this.column)
				return false;
		}
		//if there is already a piece of the same color there, not valid move
		if(hasPieceOfSameColor(square))
			return false;
		return true;
	}

	@Override
	public int[][] getPathTo(Square square) {
		
		return null;
	}

}
