package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class HomeController extends Main{

    public void goToPlay(){
//        Scene primaryStage = new Stage();
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void playButtonHandler(){
        goToPlay();
    }

}
