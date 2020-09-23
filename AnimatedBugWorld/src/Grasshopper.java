import javafx.scene.paint.Color;

public class Grasshopper extends Bug {
	// constructor taking all attributes as arguments except species and symbol	
	public Grasshopper(String name, int x, int y, int energy, int gridSize) {
		// call superclass' constructor with provided arguments plus default species and symbol
		super("Grasshopper", name, '^', x, y, energy, gridSize);
		this.setFill(Color.LIGHTGREEN); // grasshoppers are green
	}
}
