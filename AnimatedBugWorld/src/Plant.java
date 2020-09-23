import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plant extends ImageView {

	// instance attributes
	private int size; // integer value between 0 and 9.
	private char symbol; // for now the symbol is the integer representing the size
	private int x; // coordinates within world
	private int y;
	private int gridSize;
	private World world; // world plant belongs to, if any
	
	// constructor
	public Plant(int size, char symbol, int x, int y, int gridSize) {
		super(new Image("plant.png", gridSize, gridSize, false, false));
		
//		super("plant.png", gridSize, gridSize, false, false);
//		super(gridSize * x + gridSize / 2, gridSize * y + gridSize / 2, gridSize / 2);
//		super(gridSize * x + gridSize, gridSize * y + gridSize, gridSize / 2);
//		this.setFill(Color.DARKOLIVEGREEN); // plants are green
		this.size = size;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.gridSize = gridSize;
		// set world to null by default
		this.world = null;
	}

	// getters and setters
	
	// returns coordinates of top-left point of square image for displaying on grid
	public int getPosCenterX() {
		return x * gridSize; 
	}
	public int getPosCenterY() {
		return y * gridSize; 
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public int getGridX() {
		return x;
	}

	public void setGridX(int x) {
		this.x = x;
	}

	public int getGridY() {
		return y;
	}

	public void setGridY(int y) {
		this.y = y;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	@Override
	public String toString() {
		return "Plant [size=" + size + ", symbol=" + symbol + ", x=" + x + ", y=" + y + "]";
	}

}
