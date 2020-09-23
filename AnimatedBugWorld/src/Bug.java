import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bug extends ImageView {
	
	// instance attributes
	private String species;
	private String name;
	private char symbol;
	private int x; // horizontal position in grid
	private int y; // vertical position in grid
	private int gridSize; 
	private int energy;
	private World world; // world the bug belongs to, if any.
	
	// static field to store ids. don't forget it has to be static!!!
	private static ArrayList<Integer> idList = new ArrayList<Integer>(); 
	
	// overloaded constructor function taking all attributes except id as arguments. also does not initiate with a world.
	public Bug(String species, String name, char symbol, int x, int y, int energy, int gridSize, String imageFileName) {
		super(new Image(imageFileName, gridSize, gridSize, false, false));
//		super(imageFileName, gridSize, gridSize, false, false);
//		super(gridSize * x + gridSize / 2, gridSize * y + gridSize / 2, gridSize / 2);
//		super(gridSize * x + gridSize, gridSize * y + gridSize, gridSize / 2);
		this.species = species;
		this.name = name;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.gridSize = gridSize;
		this.energy = energy;
		this.world = null;
	}

	// change the bug's position, 1 coordinate at a time, either North, East, South or West
	// takes double between 0 and 1 as direction and determines movement using quadrants
	public void move(double direction) {
		
		// store initial position
		int initX = this.x;
		int initY = this.y;
		
		// declare variables to store new position. initialize new coordinates as initial coordinates.
		int newX = initX;
		int newY = initY;
		
		// argument direction should be between 0 and 1. if not, no movement happens
		if (direction < 0.25) {
			
			// move north
			newY = initY - 1;

		} else if (direction < 0.5) {
			
			// move east
			newX = initX + 1;
		
		} else if (direction < 0.75) {
		
			// move south
			newY = initY + 1;
		
		} else if (direction < 1) {
			
			// move west
			newX = initX - 1;
			
			
		}
		
		// if the bug belongs to a world,
		if (this.world != null) {
			
			// first check it did not move out of the world's borders. obtain world width and height
			int width = this.world.getWidth();
			int height = this.world.getHeight();
			
			// send it to the opposite side if it does! this world is a sphere!
			// note that the coordinates begin at 0 and end at width -1 and height - 1
			
			// check x coordinate
			if (newX < 0) {
				newX = width - 1;
			} else if (newX > width - 1) {
				newX = 0;
			}
			
			// check y coordinate
			if (newY < 0) {
				newY = height - 1;
			} else if (newY > height - 1) {
				newY = 0;
			}
			
			// next, check it did not move to a spot already occupied by another bug.
			if (world.isOccupied(newX, newY)) {
				
				// if it is, move it back to its original position
				newX = initX;
				newY = initY;
			}
			
		}
		
		// set new position
		this.x = newX;
		this.y = newY;
	}
	
	
	// Getters and setters
	
	// return position of center of circle for purpose of displaying in GUI
	// bottom line returns coordinates of top-left point of square image for displaying on grid
	public int getPosCenterX() {
//		return x * gridSize + gridSize / 2; 
//		return x * gridSize + gridSize; 
		return x * gridSize; 
	}
	public int getPosCenterY() {
//		return y * gridSize + gridSize / 2; 
//		return y * gridSize + gridSize; 
		return y * gridSize; 
	}
	
	// positions within grid
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}

	// toString and toText methods
	public String toString() {
		return name + " the " + species + " (" + symbol + ") is at (" + x + ", " + y
				+ ") and has " + energy + " energy remaining.";
	}

	
}
