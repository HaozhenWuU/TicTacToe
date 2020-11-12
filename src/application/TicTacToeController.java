package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


public class TicTacToeController extends Main{
	

	Button[] btns = new Button[9];
	int player = 0;
	int gameplay[]= {3,3,3,3,3,3,3,3,3};
	int winstate[][] = {
			{0,1,2},
			{0,3,6},
			{0,4,8},
			{1,4,7},
			{2,5,8},
			{3,4,5},
			{6,7,8},
			{2,4,6}
	};




	private boolean isXTurn = true;

	//This is a working implementation of Multiplayer (without win logic)
//	public void putCharacter(Button button) {
////		String buttonID = button.getId().toString();
////		System.out.println(buttonID);
////		one.getId()
//		String style = button.getStyle().toString();
//
//		if(isXTurn){
//			button.setGraphic(new ImageView(new Image("file:src/resources/Cross.png")));
//			button.setDisable(true);
//			button.setOpacity(1);
////			button.setStyle(style);
//			isXTurn = !isXTurn;
//		}else{
//			button.setGraphic(new ImageView(new Image("file:src/resources/O.png")));
//			button.setDisable(true);
//			button.setOpacity(1);
////			button.setStyle(style);
//			isXTurn = !isXTurn;
//		}
//
//
//	}


	/**
	 *
	 * @param button
	 * The tic tac toe game board is made up of 9 buttons, each is initially blank and clickable.
	 * putCharacter places a character in the button and then removes the ability of the button to be clicked
	 */
	public void putCharacter(Button button) {
		getButtonInfo(button);

//		String buttonID = button.getId().toString();
//		System.out.println(buttonID);
//		one.getId()
		String style = button.getStyle().toString();

		//if XTurn is true, then we place an X in the box
		//Otherwise Place the O
		//Then disable the button so it cannot be clicked again, and set the opacity to 1,
		// preventing the image from being greyed out
		//Finally, set isXturn to the opposite of its current value so we can alternate between players
		if(isXTurn){
			button.setGraphic(new ImageView(new Image("file:src/resources/Cross.png")));
			button.setDisable(true);
			button.setOpacity(1);
//			button.setStyle(style);
			isXTurn = !isXTurn;
		}else{
			button.setGraphic(new ImageView(new Image("file:src/resources/O.png")));
			button.setDisable(true);
			button.setOpacity(1);
//			button.setStyle(style);
			isXTurn = !isXTurn;
		}

	}
	//sets the current scene back to the home page
	public void quit(){
		//
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root,600,600);
			rootStage.setScene(scene);
			rootStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	//All the buttons that make up the tic tac toe game board
	@FXML Button one;
	@FXML Button two;
	@FXML Button three;
	@FXML Button four;
	@FXML Button five;
	@FXML Button six;
	@FXML Button seven;
	@FXML Button eight;
	@FXML Button nine;
	//Event handlers for various buttons.
	//buttons one through nine make up the tic tac toe game board
	//Each handler is tied uniquely to its own button.
	public void buttonOneEventHandler(){
		putCharacter(one);
	}
	public void buttonTwoEventHandler(){
		putCharacter(two);
	}
	public void buttonThreeEventHandler(){
		putCharacter(three);
	}
	public void buttonFourEventHandler(){
		putCharacter(four);
	}
	public void buttonFiveEventHandler(){
		putCharacter(five);
	}
	public void buttonSixEventHandler(){
		putCharacter(six);
	}
	public void buttonSevenEventHandler(){
		putCharacter(seven);
	}
	public void buttonEightEventHandler(){
		putCharacter(eight);
	}
	public void buttonNineEventHandler(){
		putCharacter(nine);
	}


	//the event handler for the quit option
	public void quitHandler(){quit();};



	//was used for debugging. no need for it at the moment. Keeping for future use
	@FXML
	private void getButtonInfo(Button button){
		String bounds = button.getLayoutBounds().toString();
		System.out.println(bounds);

		String buttonID = button.getId().toString();
		System.out.println(buttonID);
	}


	
 
}
