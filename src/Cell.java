
public class Cell extends Entity {

	public Cell(int col, int row) {

		setX(col);
		setY(row);

	}

	public boolean isObstacle() {

		//or occupied by spike
		return Main.display.occupiedByWall(getX(), getY());

	}

}
