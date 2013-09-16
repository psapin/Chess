package test;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import board.Board;
import enums.BoardType;


public class BoardTest {

	
	@Test
    public void testBoardClassic() throws Exception {
	    int width = 8;
	    int height = 8;
	    Board board = new Board(width, height, BoardType.CLASSIC);
        assertEquals(height, board.getRows());
        assertEquals(width, board.getColumns());
    }


	@Test
	public void testPieceMovementWhenBlocked() {
		int width = 8;
	    int height = 8;
	    Board board = new Board(width, height, BoardType.CLASSIC);
	    assertEquals(false, board.move(0,0,2,2,Color.BLACK));
	}
	
	@Test
	public void testPieceMovementWhenWrongColor() {
		int width = 8;
	    int height = 8;
	    Board board = new Board(width, height, BoardType.CLASSIC);
	    assertEquals(false, board.move(1,0,2,0,Color.WHITE));
	}

}
