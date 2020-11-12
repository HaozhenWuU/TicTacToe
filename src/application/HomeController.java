package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class HomeController extends Main{

    public void goToPlay(){
 
    	/*
    	 * The new pane is pointed to the TicTacToe game play scene. 
    	 * When the play button in the home page is clicked, scene would 
    	 * be changed from home page to the game play page. 
    	 * 
    	 */
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Set the action of the play button to be goToPlay, and switch from home page to game play page.
     * 
     */
    public void playButtonHandler(){
        goToPlay();
    }

}
