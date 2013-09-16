package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import board.Board;
import enums.BoardType;

public class MainFrame extends JFrame{
	
	private Board board;
	
	/**
	 * Sets up the frame and adds the menu and main panel
	 * @param b the board to create the gui from
	 * @param type the type of board layout to create the game for
	 */
	public MainFrame(Board b, BoardType type) {
		board = b;
		this.setTitle("Chess");
		this.setSize(600, 600);
		this.setJMenuBar(setUpMenu());
		
		JPanel boardPanel;
		switch(type){
		case CLASSIC:	boardPanel = new ClassicBoardPanel(board); break;
		default:		boardPanel = new ClassicBoardPanel(board); break;
		}
		this.add(boardPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	/**
	 * @return returns a menu bar with a file menu and new game menu item
	 */
	private JMenuBar setUpMenu() {
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        //newGame.addActionListener
        file.add(newGame);
        menubar.add(file);
        return menubar;
    }


}
