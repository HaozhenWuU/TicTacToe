package application;
	
import java.awt.event.MouseEvent;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	static Stage rootStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			rootStage = primaryStage;
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root,600,600);
			rootStage.setScene(scene);
			rootStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
