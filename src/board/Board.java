package board;

import java.awt.Color;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import enums.BoardType;


public class Board {

	private int columns;
	private int rows;
	private Square[][] squares;
	
	private Square whiteKing;
	private Square blackKing;
	
	/**
	 * Board	-	Constructor
	 * @param boardWidth -	width of the board
	 * @param boardHeight -	height of the board
	 * @param boardType	-	type of the board setup
	 */
	public Board(int boardWidth, int boardHeight, BoardType boardType) {
		columns = boardWidth;
		rows = boardHeight;
		squares = new Square[columns][rows];
		switch(boardType){
		case LONG:
		case CLASSIC:	setupClassicStartConfig(); break;
		}
	}
	
	/**
	 * @param row the row to get the piece from
	 * @param column the column to get the piece from
	 * @return returns the piece at the given location
	 */
	public Piece getPieceAt(int row, int column) {
		return squares[row][column].getPiece();
	}
	
	/**
	 * move - move a piece from a start square to a destination square
	 * @param startRow - the row coord of the piece to move
	 * @param startCol - the column coord of the piece to move
	 * @param endRow	 - the row coord of the square to move to
	 * @param endCol	 - the column coord of the square to move to
	 * @param playerColor - the color of the player who is moving a piece
	 * @return true if the move was successful, false if not
	 */
	public boolean move(int startRow, int startCol, int endRow, int endCol, Color playerColor) {
		//make sure indexes are in bounds
		if(startRow < 0 || startRow >= rows || startCol < 0 || startCol >= columns)
			return false;
		if(endRow < 0 || endRow >= rows || endCol < 0 || endCol >= columns)
			return false;
		//set squares
		Square start = squares[startRow][startCol];
		Square end = squares[endRow][endCol];
		//if start square has no piece, not valid move
		if(!start.hasPiece())
			return false;
		//otherwise get the piece to move
		Piece startPiece = start.getPiece();
		//if that piece is not the player's color, not valid move
		if(startPiece.getColor() != playerColor)
			return false;
		//if the end location is not valid, not valid move
		if(!startPiece.canMoveTo(end))
			return false;
		//if the piece encounters collisions on its path, not valid move
		if(hasCollisions(startPiece.getPathTo(end)))
			return false;
		
		//set the end piece
		Piece endPiece;
		if(end.hasPiece())
			endPiece = end.getPiece();
		else
			endPiece = null;
		
		//actually do the move
		end.setPiece(startPiece);
		start.setPiece(null);
		startPiece.moveTo(end);
		
		//check for check, revert move if putting self in check
		boolean inCheck = playerColor==Color.WHITE ? isCheck(whiteKing) : isCheck(blackKing);
		if(inCheck){
			end.setPiece(endPiece);
			start.setPiece(startPiece);
			startPiece.moveTo(start);
			return false;
		}
		
		return true;
	}
	
	/**
	 * hasCollisions - tests if there are any pieces along the given path
	 * @param path a 2d array containing the coordinates of each square along the path
	 * @return	true if collision detected, false if not
	 */
	private boolean hasCollisions(int[][] path) {
		if(path == null)
			return false;
		for(int x = 0; x < path.length; x++) {
			Square currSquare = squares[path[x][0]][path[x][1]];
			if(currSquare.hasPiece())
				return true;
		}
		return false;
	}
	
	/**
	 *  setupClassicStartConfig - sets up the game board with the classic chess layout
	 * 		with black starting on top and white on bottom
	 * @return true if setup successful, false if not
	 */
	private boolean setupClassicStartConfig() {
		if(columns != 8 || rows < 8)
			return false;
		
		//initialize all the squares with alternating colors
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				Color c;
				if(i%2 == 0)
					c = j%2 == 0 ? Color.WHITE : Color.BLACK;
				else
					c = j%2 == 0 ? Color.BLACK : Color.WHITE;
				squares[i][j] = new Square(i, j, c, true);
			}
		}
		
		setupClassicBackRow(0, Color.BLACK);
		setupPawnRow(1, Color.BLACK, columns);
		setupClassicBackRow(rows-1, Color.WHITE);
		setupPawnRow(rows-2, Color.WHITE, columns);
		
		return true;
	}
	
	
	/**
	 * setupClassicBackRow	-	adds back row of pieces for a classic setup
	 * @param row -	the row number to set the pieces on
	 * @param c	-	the color of the pieces
	 */
	private void setupClassicBackRow(int row, Color c){
		squares[row][0].setPiece(new Rook(c, row, 0));
		squares[row][1].setPiece(new Knight(c, row, 1));
		if(c==Color.WHITE)
			whiteKing = squares[row][1];
		if(c==Color.BLACK)
			blackKing = squares[row][1];
		squares[row][2].setPiece(new Bishop(c, row, 2));
		squares[row][3].setPiece(new Queen(c, row, 3));
		squares[row][4].setPiece(new King(c, row, 4));
		squares[row][5].setPiece(new Bishop(c, row, 5));
		squares[row][6].setPiece(new Knight(c, row, 6));
		squares[row][7].setPiece(new Rook(c, row, 7));
	}
	
	/**
	 * setupPawnRow -	fills a row with pawn pieces
	 * @param row	-	the row number to set the pieces on
	 * @param c	-	the color of the pieces
	 * @param numPawns - the number of pawn pieces to put down in the row
	 */
	private boolean setupPawnRow(int row, Color c, int numPawns){
		if(numPawns > columns || row > rows-1)
			return false;
		for(int i=0; i<numPawns; i++)
			squares[row][i].setPiece(new Pawn(c, row, i));
		return true;
	}
	
	private boolean isCheck(Square kingSquare) {
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				if(squares[r][c].hasPiece()){
					Piece p = squares[r][c].getPiece();
					if(p.getColor() != kingSquare.getPiece().getColor()) {
						if(p.canMoveTo(kingSquare))
							return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the squares
	 */
	public Square[][] getSquares() {
		return squares;
	}
	
	/**
	 * @return the square at the given location, null if bad location
	 */
	public Square getSquare(int aRow, int aCol) {
		if(aRow >= 0 && aRow < rows && aCol >= 0 && aCol < columns)
			return squares[aRow][aCol];
		else
			return null;
	}
	
}
