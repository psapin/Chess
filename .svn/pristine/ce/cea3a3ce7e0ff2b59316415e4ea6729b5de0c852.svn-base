package pieces;
import java.awt.Color;

import board.Square;


public class Knight extends Piece {

	public Knight(Color c, int xLoc, int yLoc){
		super(c, xLoc, yLoc);
	}
	
	@Override
	public
	boolean canMoveTo(Square square) {
		//if starting square is the same, not valid move
		if(isSameSquare(square))
			return false;
		//if there is already a piece of the same color there, not valid move
		if(hasPieceOfSameColor(square))
			return false;
		//if not one of the 8 valid moves, return false
		if(!(Math.abs(square.getColumn()-column) == 2 && Math.abs(square.getRow()-row) == 1) &&
				!(Math.abs(square.getColumn()-column) == 1 && Math.abs(square.getRow()-row) == 2))
			return false;
		return true;
	}

	@Override
	public int[][] getPathTo(Square square) {
		//knight can leap over pieces, so path is not important.
		return null;
	}

}
