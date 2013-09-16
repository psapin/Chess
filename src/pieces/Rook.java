package pieces;

import java.awt.Color;

import board.Square;


public class Rook extends Piece {
	
	public Rook(Color c, int row, int column){
		super(c, row, column);
	}
	
	
	@Override
	public boolean canMoveTo(Square square) {
		//if starting square is the same, not valid move
		if(isSameSquare(square))
			return false;
		//if the square is not on the same row or the same column, not valid move
		if(square.getRow() != this.row && square.getColumn() != this.column)
			return false;
		//if there is already a piece of the same color there, not valid move
		if(hasPieceOfSameColor(square))
			return false;
		return true;
	}
		

	@Override
	public int[][] getPathTo(Square square) {
		int[][] path;
		if(square.getRow() == row) {
			path = new int[Math.abs(square.getColumn() - column)][2];
			int counter = 0;
			if(square.getColumn() > column){
				for(int col = column; col < square.getColumn(); col++) {
					path[counter][0] = row;
					path[counter][1] = col;
					counter++;
				}
			}else {
				for(int col = column; col > square.getColumn(); col--) {
					path[counter][0] = row;
					path[counter][1] = col;
					counter++;
				}
			}
		} else {
			path = new int[Math.abs(square.getRow() - row)][2];
			int counter = 0;
			if(square.getRow() > row) {
				for(int ro = row; ro < square.getRow(); ro++) {
					path[counter][0] = ro;
					path[counter][1] = column;
					counter++;
				}
			} else {
				for(int ro = row; ro > square.getRow(); ro--) {
					path[counter][0] = ro;
					path[counter][1] = column;
					counter++;
				}
			}
		}
		return path;
	}

}
