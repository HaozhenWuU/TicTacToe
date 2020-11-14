package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class TicTacToeController extends Main{
	

	Button[] btns = new Button[9];
	int player = 0;
	int gameplay[]= {3,3,3,3,3,3,3,3,3};
	int winstate[][] = {
			{1,2,3},
			{1,4,7},
			{1,5,9},
			{2,5,8},
			{3,6,9},
			{4,5,6},
			{7,8,9},
			{3,5,7}
	};
//ArrayList[][] winState;
ArrayList<Integer> xButtons = new ArrayList<Integer>();
ArrayList<Integer> oButtons = new ArrayList<Integer>();
ArrayList<Integer> winningButtons = new ArrayList<Integer>();
private boolean isXTurn = true;
private boolean winnerDeclared = false;

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
			xButtons.add(Integer.parseInt(button.getText()));
			Collections.sort(xButtons);
//			boolean deleteThis= hasWinningCombination(xButtons);

			if(xButtons.size()>=3){
				if(hasWinningCombination(xButtons)){
					System.out.println("WINNER IS X");
					board.setDisable(true);
					winnerDeclared=true;
					drawLineThroughWin();


				}
			}
		}else{
			button.setGraphic(new ImageView(new Image("file:src/resources/O.png")));
			button.setDisable(true);
			button.setOpacity(1);
//			button.setStyle(style);
			isXTurn = !isXTurn;
			oButtons.add(Integer.parseInt(button.getText()));
			Collections.sort(oButtons);
//			boolean deleteThis= hasWinningCombination(oButtons);

			if(oButtons.size()>=3){

				if(hasWinningCombination(oButtons)) {
					System.out.println("WINNER IS O");
					board.setDisable(true);
					winnerDeclared=true;
					drawLineThroughWin();

				}
			}
		}
		if(xButtons.size()+oButtons.size()==9 && !winnerDeclared){
			System.out.println("DRAW");
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

	public void checkForAWinner(String s){

		if(s=="x"){

		}else{

		}
	}

	public boolean hasWinningCombination(ArrayList<Integer> arrayList){

		//Compare each subaray of length 3 in arrayList to each array in winstate
		//if theres a match, return true
		System.out.println("arrayList to string:");
		System.out.println(arrayList.toString());

		//first for loop is to get every subarray of size 3
		for(int i =0; i <=arrayList.size()-3; i++){
			List<Integer> subarray = arrayList.subList(i,i+3);
			System.out.println("subarray.toString():");
			System.out.println(subarray.toString());
			//second for loop is for fist dimension of 2d winstate array
			for(int j =0; j<winstate.length-1;j++){
				System.out.println("winstate j");

				//3rd for loop is for 2nd dimension of 2d winstate array
				ArrayList<Integer> matched = new ArrayList<Integer>();
				for(int k = 0 ; k<winstate[j].length;k++){
					System.out.println(winstate[j][k]);

					if(arrayList.contains(winstate[j][k])){
						matched.add(winstate[j][k]);
					}

				}
				System.out.println("matched:");
				System.out.println(matched.toString());
				System.out.println("matched.size()");
				System.out.println(matched.size());


				if(matched.size()==3){
					winningButtons=matched;
					return true;
				}else{
					matched.clear();
				}
//				subarray.toArray();
//				if(winstate[j]==subarray){
//					return true;
//				}

			}
		}
		return false;

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
	@FXML GridPane board;
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
		for(int i=1;i<=9;i++){
			System.out.println("intToButton("+i+").localToScene(intToButton("+i+").getBoundsInLocal())");
			System.out.println(intToButton(i).localToScene(intToButton(i).getBoundsInLocal()));
		}

//		String bounds = button.getLayoutBounds().toString();
//		System.out.println(bounds);
//
//		String buttonID = button.getId().toString();
//		System.out.println(buttonID);
//
//		int buttonIntID = Integer.parseInt(button.getText());
//		System.out.println("this is button ID to int");
//		System.out.println(buttonIntID);
//		button.getText();
	}


	public Button intToButton(int i) {

		switch (i){
			case 1:
				return one;
			case 2:
				return two;
			case 3:
				return three;
			case 4:
				return four;
			case 5:
				return five;
			case 6:
				return six;
			case 7:
				return seven;
			case 8:
				return eight;
			case 9:
				return nine;
			default:
				return null;
		}
	}

	//Work in progress.
	public void drawLineThroughWin(){
//		Button start = intToButton(winningButtons.get(0));
//		Button end = intToButton(winningButtons.get(2));
//		Bounds startBounds = start.localToScene(start.getBoundsInLocal());
//		Bounds endBounds = end.localToScene(end.getBoundsInLocal());
//
//		double minStartX =
//
////		double startX = startBounds.getMaxX();
////		double minStartX = startBounds.getMinX();
////		double startY = startBounds.getMaxY();
////		double minStartY = startBounds.getMinY();
////
////
////		double endX = endBounds.getMaxX();
////
////		double endY = endBounds.getMaxY();
//
//		Line line = new Line(startX,startY,endX,endY);
//		board.getChildren().add(line);
	}
 
}
