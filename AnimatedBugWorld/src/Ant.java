import javafx.scene.paint.Color;

public class Ant extends Bug {
	private static String defaultSpecies = "Ant";
	private static char defaultSymbol = '%';

	public Ant(String name, int x, int y, int energy, int gridSize) {
		super(defaultSpecies, name, defaultSymbol, x, y, energy, gridSize, "ant.png");
//		this.setFill(Color.BROWN); // ants are brown
	}
	
}
