package pieces;

import java.awt.Color;

import board.Square;


public class Bishop extends Piece {

	public Bishop(Color c, int xLoc, int yLoc){
		super(c, xLoc, yLoc);
	}
	
	@Override
	public boolean canMoveTo(Square square) {
		//if no movement, not valid move
		if(isSameSquare(square))
			return false;
		// if not diagonal (change in x == change in y), not valid move
		if(Math.abs(square.getRow() - row) != Math.abs(square.getColumn() - column))
			return false;
		//if there is already a piece of the same color there, not valid move
		if(hasPieceOfSameColor(square))
			return false;
		return true;
	}

	@Override
	public int[][] getPathTo(Square square) {
		int[][] path = new int[Math.abs(square.getColumn() - column-1)][2];
		int counter = 0;
		if(square.getRow() - row > 0) {
			if(square.getColumn() - column > 0) {
				for(int col = column+1; col < square.getColumn(); col++) {
					path[counter][0] = col;
					path[counter][1] = col;
					counter++;
				}
			} else {
				int rowCount = row+1;
				for(int col = column-1; col > square.getColumn(); col--) {
					path[counter][0] = rowCount;
					path[counter][1] = col;
					rowCount++;
					counter++;
				}
			}
		} else {
			if(square.getColumn() - column < 0) {
				for(int col = column-1; col > square.getColumn(); col--) {
					path[counter][0] = col;
					path[counter][1] = col;
					counter++;
				}
			} else {
				int rowCount = row-1;
				for(int col = column+1; col < square.getColumn(); col++) {
					path[counter][0] = rowCount;
					path[counter][1] = col;
					rowCount--;
					counter++;
				}
			}
		}
		
		return path;
	}

}
