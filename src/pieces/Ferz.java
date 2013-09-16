package pieces;

import java.awt.Color;

import board.Square;


public class Ferz extends Piece {

	public Ferz(Color c, int xLoc, int yLoc){
		super(c, xLoc, yLoc);
	}
	
	@Override
	public boolean canMoveTo(Square square) {
		//if no movement, not valid move
		if(isSameSquare(square))
			return false;
		//if the change in row and column is not one, not valid move
		if(Math.abs(square.getRow()-row) != 1 && Math.abs(square.getColumn()-column) != 1)
			return false;
		//if there is an existing piece of the same color, not valid move
		if(hasPieceOfSameColor(square))
			return false;
		return true;
	}

	@Override
	public int[][] getPathTo(Square square) {
		//can only move one space, so path is null
		return null;
	}

}
