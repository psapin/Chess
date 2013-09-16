package pieces;

import java.awt.Color;

import board.Square;


public class Pawn extends Piece {
	
	private int startRow;
	private int startCol;

	public Pawn(Color c, int xLoc, int yLoc){
		super(c, xLoc, yLoc);
		startRow = xLoc;
		startCol = yLoc;
	}
	
	@Override
	public boolean canMoveTo(Square square) {
		if(row == startRow && column == startCol)
			return canMoveFirstTurnTo(square);
		//if starting square is the same, not valid move
		if(isSameSquare(square))
			return false;
		
		if(color == Color.BLACK) {
			//if not the next row, not valid move
			if(square.getRow()-row != 1)
				return false;
		} else if (color == Color.WHITE) {	
			//if not the next row, not valid move
			if(square.getRow()-row != -1)
				return false;
		}
		//if diagonal move
		if(Math.abs(square.getColumn()-column) == 1){
			//if the diagonal square either has no piece, or one of the same color, not valid move
			if(!square.hasPiece() || square.getPiece().getColor() == color)
				return false;
		}
		//if there is already a piece of the same color there, not valid move
		if(hasPieceOfSameColor(square))
			return false;
			
		return true;
	}
	
	public boolean canMoveFirstTurnTo(Square square) {
		//if starting square is the same, not valid move
		if(isSameSquare(square))
			return false;
		
		if(color == Color.BLACK) {
			//if not the next 2 rows, not valid move
			if(square.getRow()-row > 2)
				return false;
		} else if (color == Color.WHITE) {	
			//if not the next 2 rows, not valid move
			if(square.getRow()-row < -2)
				return false;
		}
		//if diagonal move
		if(Math.abs(square.getColumn()-column) == 1)
			return false;
		//if there is already a piece of the same color there, not valid move
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
