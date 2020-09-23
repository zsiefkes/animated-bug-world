import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserInterface extends Application {
	// set display sizes. width and height of window are determined by gridWidth, gridHeight and radius of object avatars (circles).
	private int radius = 10;
	private int gridWidth = 20, gridHeight = 10;
	private int width = gridWidth * 2 * radius + radius;
	private int height = gridHeight * 2 * radius + radius;
	private int btnHeight = 40; // additional height to add to bottom of window for pause/play button

	// declare bug world related fields
	private World world;
	private ArrayList<Bug> bugs;
	private ArrayList<Plant> plants;
	
	// declare javaFX objects 
	Button playPauseButton;
	boolean isPaused;
	VBox layout;
	Timeline timeline;
	
	// ----------------------------------------------------------------------------------------- //
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// create bug world
		World world = new World(gridWidth, gridHeight, radius * 2);
		
		// populate world
		world.genBugs(10);
		world.genPlants(10);
		
		// fetch animals and geographic features
		bugs = world.getBugs();
		plants = world.getPlants();
		
		// create a pane to hold the bugs and plants. using pane not group so that we can set the dimensions.
		Pane worldObjects = new Pane();
		worldObjects.setMinSize(width, height);
		for (Bug b : bugs) {
			worldObjects.getChildren().add(b);
		}
		for (Plant p : plants) {
			worldObjects.getChildren().add(p);
		}

		// create play/pause button to control island animation
		playPauseButton = new Button();
		playPauseButton.setText("Play");
		playPauseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (isPaused) {
					timeline.play();
					playPauseButton.setText("Pause");
					isPaused = false;
				} else {
					timeline.pause();
					playPauseButton.setText("Play");
					isPaused = true;
				}
			}
		});
		
		// create a vbox to store the world pane and the play/pause button
		layout = new VBox();
		layout.setMinHeight(height);
		layout.getChildren().add(worldObjects);
		layout.getChildren().add(playPauseButton);
		layout.setAlignment(Pos.CENTER);
		
		// define keyframe action
		KeyFrame frame = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// each new frame should update the island.
				world.updateWorld();

				// update bug positions
				for (Bug b : bugs) {
					System.out.println(b.toString());
					// update the position
					b.setCenterX(b.getPosCenterX());
					b.setCenterY(b.getPosCenterY());
				}

			}
		});
		
		// instantiate timeline and add keyframe.
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(frame);
		isPaused = true;
		
		// create scene on worldObjects group
		Scene scene = new Scene(layout, width, height + btnHeight);
		
		primaryStage.setTitle("Animated Bug World");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
