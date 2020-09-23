import java.util.ArrayList;

public class Obstacle {

	// instance attributes
	private char symbol = 'x'; // default symbol representing all objects
	private int x; // coordinates within world
	private int y;
	private World world; // world object belongs to, if any

	// static field to store ids
	private static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	// constructor
	public Obstacle( int x, int y) {
		this.x = x;
		this.y = y;
		// set world to null by default
		this.world = null;
	}

	// getters and setters

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
