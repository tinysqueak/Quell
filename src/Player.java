import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sun.glass.events.KeyEvent;

/**
 * 
 * @author William Yang
 *
 */
public class Player extends Entity {

	private static BufferedImage sprite;

	/**
	 * Creates a new <code>Player</code> with given coordinates
	 * @param x The x-coordinate of the <code>Player</code>
	 * @param y The y-coordinate of the <code>Player</code>
	 */
	public Player(int x, int y) {

		setX(x);
		setY(y);

	}

	/**
	 * Sets the image of the <code>Player</code>
	 * @param image The <code>BufferedImage</code> with which to set the <code>Player</code> sprite to
	 */
	public static void setImage(BufferedImage image) {

		sprite = image;

	}

	/**
	 * Gets the image of the <code>Player</code>
	 * @return The sprite of the <code>Player</code> as a <code>BufferedImage</code>
	 */
	public static BufferedImage getImage() {

		return sprite;

	}

	/**
	 * Draws the <code>Player</code> sprite based on cell boundaries, initial offsets,
	 * and the cell coordinates of the <code>Player</code>
	 * @author William
	 */
	@Override
	public void draw(int xOffset, int yOffset, int width, int height, Graphics g) {

		int xLeft = xOffset + 1 + (getX() * (width + 1));
		int yTop = yOffset + 1 + (getY() * (height + 1));

		g.drawImage(sprite, xLeft, yTop, width, height, null);

	}

	public int farthestAccesible(int direction) {

		switch(direction) {

		//may need to change for cases for 'infinite movement loop'
		case KeyEvent.VK_UP:
			int minY = getY();
			while(!Grid.cell[getX()][minY].isObstacle()) {
				
				minY--;
				
			}
			return minY + 1;
			
			/*for(int y = getY(); y >= 0; y--) {

				if(Grid.cell[getX()][y].isObstacle(getX(), y)) {

					return y;

				}

			}*/

		case KeyEvent.VK_DOWN:
			int maxY = getY();
			while(!Grid.cell[getX()][maxY].isObstacle()) {
				
				maxY++;
				
			}
			
			return maxY - 1;
			/*for(int y = getY(); y >= Main.display.maps.get(0).length; y++) {

				if(Grid.cell[getX()][y].isObstacle(getX(), y)) {

					return y;
					
				}

			}*/

		case KeyEvent.VK_RIGHT:
			int maxX = getX();
			while(!Grid.cell[maxX][getY()].isObstacle()) {
				
				maxX++;
				
			}
			
			return maxX - 1;
			
			/*for(int x = getX(); x <= Main.display.maps.get(0)[0].length; x++) {

				if(Grid.cell[x][getY()].isObstacle(x, getY())) {

					return x;
					
				}
				
			}
			break;
*/
		case KeyEvent.VK_LEFT:
			int minX = getX();
			while(!Grid.cell[minX][getY()].isObstacle()) {
				
				minX--;
				
			}
			
			return minX + 1;
			/*for(int x = getX(); x >= 0; x--) {
				
				if(Grid.cell[x][getY()].isObstacle(x, getY())) {
					
					return x;
					
				}
				
			}
			break;*/

		default:
			return getX();

		}
		//String message = "";
		//boolean lost = false;

		//move(x, y);
		//Main.display.repaint();

		//or occupied by spike
		/*if (Main.display.occupiedByWall(x, y)) {

			lost = true;

			//message is specific to the reason of player death (moving onto fence, jumping onto mho, or moving onto mho)
			//implemented with multiple ternary operators
			message = Main.display.occupiedBySpike(x, y) ? "You have moved onto a Fence! " : (jump ? "You have jumped onto a Mho! " : "You have moved onto a Mho! ");

			//also passes relevant icon to player's death to gameOver method
			Main.display.gameOver(false, message, (Main.display.occupiedByWall(x, y) ? Grid.fenceIcon : Grid.mhoIcon));

		}*/

		//return lost;

	}


}
