package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import board.Board;
import board.Square;

public class ClassicBoardPanel extends JPanel {

	/**
	 * creates a panel containing the classic chess board layout
	 * @param b the source board to create the graphical board from
	 */
	public ClassicBoardPanel(Board b) {
		this.setLayout(new GridLayout(8,8));
		
		for(int row = 0; row < b.getRows(); row++){
			for(int col = 0; col < b.getColumns(); col++) {
				Square sq = b.getSquare(row, col);
				if(sq != null)
					this.add(createSquareButton(sq));
			}
		}
	}
	
	/**
	 * creates a button for a square on the game board
	 * @param s	The square to make a button out of
	 * @return returns the new JButton for that square
	 */
	private JButton createSquareButton(Square s) {
		ImageIcon myImage = null;
		if(s.hasPiece()){
			Piece p = s.getPiece();
			String color = p.getColor() == Color.WHITE ? "white" : "black";
			if(p instanceof Pawn)
				myImage = new ImageIcon("images/"+color+"/pawn.png");
			else if(p instanceof Rook)
				myImage = new ImageIcon("images/"+color+"/rook.png");
			else if(p instanceof Knight)
				myImage = new ImageIcon("images/"+color+"/knight.png");
			else if(p instanceof Bishop)
				myImage = new ImageIcon("images/"+color+"/bishop.png");
			else if(p instanceof Queen)
				myImage = new ImageIcon("images/"+color+"/queen.png");
			else if(p instanceof King)
				myImage = new ImageIcon("images/"+color+"/king.png");
		}
		JButton squareButton = new JButton(myImage);
		squareButton.setBackground(s.getColor());
		squareButton.setBorderPainted(false);  
        squareButton.setFocusPainted(false);
		squareButton.setOpaque(true);
		//squareButton.setText(""+s.hasPiece());
		return squareButton;
	}
	
}
