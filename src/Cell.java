
public class Cell extends Entity {

	public Cell(int col, int row) {
		
		setX(col);
		setY(row);
		
	}
	
	public boolean isObstacle() {
		
		//return this instanceof
		return false;
		
	}
	
}
