package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class SampleController {
	

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

	@FXML Button one;
	@FXML Button two;
	@FXML Button three;
	@FXML Button four;
	@FXML Button five;
	@FXML Button six;
	@FXML Button seven;
	@FXML Button eight;
	@FXML Button nine;

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

	public void putCharacter(Button button) {
//		String buttonID = button.getId().toString();
//		System.out.println(buttonID);
//		one.getId()
		String style = button.getStyle().toString();

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
	@FXML
	private void getButtonID(Button button){
		String buttonID = button.getId().toString();
		System.out.println(buttonID);
	}
	
 
}
