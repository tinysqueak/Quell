
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Grid extends JComponent implements KeyListener, MouseListener {

	public static Cell[][] cell;

	public final int ROWS;
	public final int COLS;

	private final int X_GRID_OFFSET = 0;
	private final int Y_GRID_OFFSET = 0;

	private final int CELL_WIDTH = 65;
	private final int CELL_HEIGHT = 65;

	private final int DISPLAY_WIDTH;
	private final int DISPLAY_HEIGHT;

	private Player player;

	private boolean gameOver;

	private ArrayList<Pearl> pearlList;
	private ArrayList<Block> blockList;

	public ArrayList<Integer[][]> maps;

	public Grid(int width, int height, int rows, int cols) {

		pearlList = new ArrayList<Pearl>();
		blockList = new ArrayList<Block>();

		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;

		ROWS = rows;
		COLS = cols;
		cell = new Cell[COLS][ROWS];

		addKeyListener(this);
		addMouseListener(this);

		initPlayerImage();
		initWallImage();
		initPearlImage();

		initMaps();
		initMapObjects();

	}

	/**
	 * 
	 */
	private void initMaps() {

		//initialize pearlList size to number of pearls in particular map

		/*
		 * 0 = empty cell
		 * 1 = player
		 * 2 = wall
		 * 3 = pearl
		 * 4 = spike
		 * 5 = block
		 * 6 = teleport ring
		 */

		maps = new ArrayList<Integer[][]>();

		maps.add(new Integer[][] {
			{2, 2, 2, 2, 2, 2},
			{2, 0, 0, 3, 0, 2},
			{2, 1, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2}
		});

	}

	private void initPlayerImage() {

		try {

			Player.setImage(ImageIO.read(new File("images/player.png")));

		} catch(IOException e) {

			e.printStackTrace();

		}

	}

	private void initWallImage() {

		try {

			Wall.setImage(ImageIO.read(new File("images/wall.png")));

		} catch(IOException e) {

			e.printStackTrace();

		}

	}

	private void initPearlImage() {

		try {

			Pearl.setImage(ImageIO.read(new File("images/pearl.png")));

		} catch(IOException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void paintComponent(Graphics g) {

		//g.setColor(Color.BLACK);

		//drawGrid(g);
		drawCells(g);
		drawPearls(g);
		drawPlayer(g);


	}

	private void initMapObjects() {

		Integer[][] map = maps.get(0);

		for(int row = 0; row < map.length; row++) {

			for(int col = 0; col < map[0].length; col++) {

				switch(map[row][col]) {

				case 0:
					cell[col][row] = new Cell(col, row);
					break;

				case 1:
					this.player = new Player(col, row);
					cell[col][row] = new Cell(col, row);
					break;

				case 2:
					cell[col][row] = new Wall(col, row);
					break;

				case 3:
					cell[col][row] = new Pearl(col, row);
					pearlList.add(new Pearl(col, row));
					break;

				case 4:
					cell[col][row] = new Spike(col, row);
					break;

				case 5:
					cell[col][row] = new Cell(col, row);
					blockList.add(new Block(col, row));
					break;

				case 6:
					cell[col][row] = new TeleportRing(col, row);
					break;

				default:
					break;

				}

			}

		}

	}

	private void drawGrid(Graphics g) {

		for (int row = 0; row <= ROWS; row++) {

			g.drawLine(X_GRID_OFFSET,
					Y_GRID_OFFSET + (row * (CELL_HEIGHT + 1)), X_GRID_OFFSET
					+ COLS * (CELL_WIDTH + 1), Y_GRID_OFFSET
					+ (row * (CELL_HEIGHT + 1)));

		}

		for (int col = 0; col <= COLS; col++) {

			g.drawLine(X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET,
					X_GRID_OFFSET + (col * (CELL_WIDTH + 1)), Y_GRID_OFFSET
					+ ROWS * (CELL_HEIGHT + 1));

		}

	}

	private void drawPlayer(Graphics g) {

		player.draw(X_GRID_OFFSET, Y_GRID_OFFSET, CELL_WIDTH, CELL_HEIGHT, g);

	}

	private void drawCells(Graphics g) {

		/* 
		 * draws cells based on map dimensions, can maybe change Grid constructor to take map
		 * specific dimensions?
		 */ 
		for(int row = 0; row < maps.get(0).length; row++) {

			for(int col = 0; col < maps.get(0)[0].length; col++) {

				cell[col][row].draw(X_GRID_OFFSET, Y_GRID_OFFSET, CELL_WIDTH, CELL_HEIGHT, g);

			}

		}

	}

	private void drawPearls(Graphics g) {

		for(int i = 0; i < pearlList.size(); i++) {

			pearlList.get(i).draw(X_GRID_OFFSET, Y_GRID_OFFSET, CELL_WIDTH, CELL_HEIGHT, g);

		}

	}

	public boolean occupiedByWall(int x, int y) {

		return cell[x][y] instanceof Wall;

	}

	public boolean occupiedByPearl(int x, int y) {

		return cell[x][y] instanceof Pearl;

	}

	public void gameOver() {


	}

	public void setGameOver(boolean gameOver) {

		this.gameOver = gameOver;

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		//may be some errors with player movement
		switch(arg0.getKeyCode()) {
		
		case KeyEvent.VK_UP:
		case KeyEvent.VK_KP_UP:
		case KeyEvent.VK_W:
			player.move(player.getX(), player.farthestAccesible(KeyEvent.VK_UP));
			break;

		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_KP_DOWN:
		case KeyEvent.VK_S:
			player.move(player.getX(), player.farthestAccesible(KeyEvent.VK_DOWN));
			break;

		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_KP_RIGHT:
		case KeyEvent.VK_D:
			player.move(player.farthestAccesible(KeyEvent.VK_RIGHT), player.getY());
			break;

		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_KP_LEFT:
		case KeyEvent.VK_A:
			player.move(player.farthestAccesible(KeyEvent.VK_LEFT), player.getY());
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		this.grabFocus();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

		this.grabFocus();

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
