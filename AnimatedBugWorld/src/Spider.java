import javafx.scene.paint.Color;

public class Spider extends Bug {
	// set default species and symbol as private static variables for use in constructors
	private static String defaultSpecies = "Spider";
	private static char defaultSymbol = '#';
	
	// overloaded constructor taking name, x and y position and energy level.
	public Spider(String name, int x, int y, int energy, int gridSize) {
		super(defaultSpecies, name, defaultSymbol, x, y, energy, gridSize);
		this.setFill(Color.BLACK); // spiders are black
	}
	
}
