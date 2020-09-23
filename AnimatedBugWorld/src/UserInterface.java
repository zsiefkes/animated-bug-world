import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserInterface extends Application {
	// set display sizes. width and height of window are determined by gridWidth, gridHeight and gridSize (length of square grid tiles)
	private int gridSize = 20;
	private int gridWidth = 30, gridHeight = 15;
	private int width = gridWidth * gridSize;
	private int height = gridHeight * gridSize;
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
		world = new World(gridWidth, gridHeight, gridSize);
		
		// populate world
		world.genBugs(25);
		world.genPlants(45);
		
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

		// set initial positions
		updatePositions();
		
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
				// run world object (moves bugs)
				world.updateWorld();

				// update object positions on GUI
				updatePositions();
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
	
	private void updatePositions() {
		// update bug positions
		for (Bug b : bugs) {
			b.setX(b.getPosCenterX());
			b.setY(b.getPosCenterY());
		
		// update plant positions
		for (Plant p : plants) {
			p.setX(p.getPosCenterX());
			p.setY(p.getPosCenterY());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
