
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Grid extends JComponent implements KeyListener {
	
	public static Cell[][] cell;
	
	public final int ROWS;
	public final int COLS;
	
	private final int X_GRID_OFFSET = 0;
	private final int Y_GRID_OFFSET = 0;
	
	private final int CELL_WIDTH = 5;
	private final int CELL_HEIGHT = 5;
	
	private final int DISPLAY_WIDTH;
	private final int DISPLAY_HEIGHT;
	
	private Player player;
	
	private boolean gameOver;
	
	public Grid(int width, int height, int rows, int cols) {
		
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		
		ROWS = rows;
		COLS = cols;
		cell = new Cell[COLS][ROWS];
		
		addKeyListener(this);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
