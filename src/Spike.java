import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Spike extends Cell {

	private static BufferedImage sprite;

	public Spike(int x, int y) {

		super(x, y);

	}

	/**
	 * Sets the image for the fence
	 * @param image The image to set for the fence image
	 */
	public static void setImage(BufferedImage image) {

		sprite = image;

	}

	/**
	 * Gets the image of the <code>Fence</code>
	 * @return The <code>Fence</code> sprite as a <code>BufferedImage</code>
	 */
	public static BufferedImage getImage() {

		return sprite;

	}

	/**
	 * Draws a <code>Fence</code> sprite for a certain <code>Fence</code>based on the cell boundaries,
	 * initial offsets and the cell coordinates of the particular <code>Fence</code>.
	 * @author Kevin, William
	 */
	@Override
	public void draw(int xOffset, int yOffset, int width, int height, Graphics g) {

		int xLeft = xOffset + 1 + (getX() * (width + 1));
		int yTop = yOffset + 1 + (getY() * (height + 1));

		//draws a black cell first underneath the fence sprite
		super.draw(xOffset, yOffset, width, height, g);

		g.drawImage(sprite, xLeft, yTop, width, height, null);

	}
}
