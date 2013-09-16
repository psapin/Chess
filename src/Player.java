import java.awt.Color;




public class Player {

	private Color color;
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	public Player(Color c){
		color = c;
	}
}
