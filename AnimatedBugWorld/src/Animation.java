import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Animation extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// let's test out using images!
		Label label1 = new Label("This is only text!");
		
		// image.
//		Image image = new Image(getClass().getResourceAsStream("black-electric-guitar.png"));
//		
//		// create imageview and set height and width. from https://stackoverflow.com/a/27894962
//		ImageView imageView = new ImageView(image);
//		imageView.setFitHeight(100);
//		imageView.setFitWidth(100);
//		Label label2 = new Label("However this follows a guitar!", imageView);

		// alternatively! set height and width on load. supposedly this uses less memory since full size image not stored, or something. 
		Image image = new Image("black-electric-guitar.png", 100, 100, false, false);
		Label label2 = new Label("However this follows a guitar!", new ImageView(image));
		
		// Layout text and labels in vertical boxes
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.getChildren().add(label1);
		pane.getChildren().add(label2);
		
		primaryStage.setScene(new Scene(pane));
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
