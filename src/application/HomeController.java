package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class HomeController extends Main{

    public void goToPlay(){
 
    	/*
    	 * The new pane is pointed to the Game Mode scene. 
    	 * When the play button in the home page is clicked, scene would 
    	 * be changed from home page to the game mode page. 
    	 * 
    	 */
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("GameMode.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Set the action of the play button to be goToPlay, and switch from home page to game mode page.
     * 
     */
    public void playButtonHandler(){
        goToPlay();
    }

    public void goToScores(){
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("Scores.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
