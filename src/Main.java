import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {

	public static Grid display;

	public static void main(String[] args) {

		// width in pixels of the display
		final int DISPLAY_WIDTH = 792;
		// height in pixels of the display
		final int DISPLAY_HEIGHT = 792;


		//default, max, and min sizes of the grid (side length number of cells of grid)

		// default width and height in cells of the board
		final int DEFAULT_SIZE = 12;

		JFrame f = new JFrame();

		display = new Grid(DISPLAY_WIDTH, DISPLAY_HEIGHT, DEFAULT_SIZE, DEFAULT_SIZE);

		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(display, BorderLayout.CENTER);
		f.setTitle("Quell");
		f.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		//f.setResizable(false);

	}

}
