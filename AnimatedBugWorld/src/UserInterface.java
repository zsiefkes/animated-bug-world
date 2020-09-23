import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
public class UserInterface extends Application {

	// set display sizes. width and height of window are determined by gridWidth, gridHeight and radius of object avatars (circles).
	private int radius = 10;
	private int gridWidth = 20, gridHeight = 10;
	private int width = gridWidth * 2 * radius + radius;
	private int btnHeight = 40;
	private int height = gridHeight * 2 * radius + radius + btnHeight;
	
	// declare island related fields
//	private World world;
//	private ArrayList<Rabbit> rabbits;
//	private ArrayList<Kiwi> kiwis;
//	private ArrayList<Grass> grasses;
//	private ArrayList<Water> waters;
	
	// declare bug world related fields
	private World world;
	private ArrayList<Bug> bugs;
	private ArrayList<Plant> plants;
	
	// declare javaFX objects 
	Button playPauseButton;
	boolean isPaused;
	VBox pane;
	Timeline timeline;
	
	// ----------------------------------------------------------------------------------------- //
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// create bug world
		World world = new World(gridWidth, gridHeight);
		
		// populate world
		world.genBugs(10);
		world.genPlants(10);
		
		// print bug and plant info
		world.printBugInfo();
		world.printPlantInfo();
		
		// animate world
		world.animateWorld(10);

		// fetch animals and geographic features
		bugs = world.getBugs();
		plants = world.getPlants();
		
//		// create a group to hold the animals and geographic features
//		Group worldObjects = new Group();
//		for (Bug b : bugs) {
//			worldObjects.getChildren().add(b);
//		}
//		for (Plant p : plants) {
//			worldObjects.getChildren().add(p);
//		}
//
//		// define keyframe action
//		KeyFrame frame = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				// each new frame should update the island.
//				world.updateWorld();
//
//				// update bug positions
//				for (Bug b : bugs) {
//					// update the position
//					b.setTranslateX(b.getPosCenterX());
//					b.setTranslateX(b.getPosCenterY());
//				}
//
//			}
//		});
//		
//		// instantiate timeline and add keyframe.
////		final Timeline timeline = new Timeline();
//		timeline = new Timeline();
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.getKeyFrames().add(frame);
////		timeline.play();
////		isPaused = false;
//		isPaused = true;
//		
//		// create play/pause button to control island animation
//		playPauseButton = new Button();
//		playPauseButton.setText("Play");
//		playPauseButton.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				if (isPaused) {
//					// restart the timeline play... how we do this?
//					timeline.play();
//					playPauseButton.setText("Pause");
//					isPaused = false;
//				} else {
//					timeline.pause();
//					playPauseButton.setText("Play");
//					isPaused = true;
//				}
//			}
//		});
//		
//		// create a vbox to store the animal group and also the um. play/pause button
//		pane = new VBox();
//		pane.getChildren().add(worldObjects);
//		pane.getChildren().add(playPauseButton);
//		pane.setAlignment(Pos.BOTTOM_CENTER);
//		
//		// create scene on worldObjects group
//		Scene scene = new Scene(pane, width, height);
//		
//		primaryStage.setTitle("The Animated Island");
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
