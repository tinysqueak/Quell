import java.awt.Color;
import java.awt.Graphics;

public class Entity {

	// The x coordinate in cells of the entity
	private int x;
	// The y coordinate in cells of the entity
	private int y;
	// The background color of the entity
	private Color myColor;
	
	/**
	 * Default constructor
	 */
	public Entity() {
		
	}
	
	/**
	 * Get the x-coordinate of this entity
	 * @return The x-coordinate of this entity
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set the x-coordinate of this entity
	 * @param x The new x-coordinate of this entity
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Get the y-coordinate of this entity
	 * @return The y-coordinate of this entity
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Set the y-coordinate of this entity
	 * @param y The new y-coordinate of this entity
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Get the color of this entity
	 * @return The color of this entity
	 */
	public Color getColor() {
		
		return myColor;
		
	}
	
	/**
	 * Set the color of this entity
	 * @param newColor The new color of this entity
	 */
	public void setColor(Color newColor) {
		
		this.myColor = newColor;
		
	}
	
	/**
	 * Draws an entity with a certain color based on the cell boundaries, initial offsets
	 * and the cell coordinates.
	 * 
	 * @param xOffset The horizontal distance before the first cell
	 * @param yOffset The vertical distance before the first cell
	 * @param width The width of a cell
	 * @param height The height of a cell
	 * @param g The graphics object
	 * @author William
	 */
	public void draw(int xOffset, int yOffset, int width, int height, Graphics g) {
		
		//left edge of cell
		int xLeft = xOffset + 1 + (this.x * (width + 1));
		
		//top edge of cell
		int yTop = yOffset + 1 + (this.y * (height + 1));
		
		g.setColor(myColor);
		g.fillRect(xLeft, yTop, width, height);
		
	}
	
	/**
	 * Moves the entity to the new coordinates by changing its coordinates to the
	 * specified ones.
	 * @param x The new x-coordinate
	 * @param y The new y-coordinate
	 * @author William
	 */
	public void move(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	
	
}
