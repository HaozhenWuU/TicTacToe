package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameMode extends Main {

    public void goToMultiGame(){
 
    	/*
    	 * The new pane is pointed to the TicTacToe game play scene. 
    	 * When the play button in the home page is clicked, scene would 
    	 * be changed from home page to the game play page. 
    	 * 
    	 */
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("MultiPlayer.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Set the action of the multiplayer button to be goToGame, and switch from the game mode screen to game play page.
     * 
     */
    public void multiplayerButtonHandler(){
        goToMultiGame();
    }
    
    public void goToSingleGame() {
    	  try {
              Pane root = (Pane) FXMLLoader.load(getClass().getResource("SinglePlayer.fxml"));
              Scene scene = new Scene(root,600,600);
              rootStage.setScene(scene);
              rootStage.show();
          } catch(Exception e) {
              e.printStackTrace();
          }
    	
    }
    public void singleplayerButtonHandler(){
        goToSingleGame();
    }


}
