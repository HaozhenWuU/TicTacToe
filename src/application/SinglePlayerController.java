package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class SinglePlayerController extends Main{
	

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
ArrayList<Integer> unClickedButtons = new ArrayList<>(
		Arrays.asList(1,2,3,4,5,6,7,8,9)
);

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
/**
*
* @param button
* The tic tac toe game board is made up of 9 buttons, each is initially blank and clickable.
* putCharacter places a character in the button and then removes the ability of the button to be clicked
*/
public void putCharacter(Button button) {

	//take in single player button. default singel player is the x
		button.setGraphic(new ImageView(new Image("file:src/resources/Cross.png")));
		button.setDisable(true);
		button.setOpacity(1);

		xButtons.add(Integer.parseInt(button.getText()));
		Collections.sort(xButtons);

		if(xButtons.size()>=3){
			if(hasWinningCombination(xButtons)){
				System.out.println("WINNER IS X");
				winDialog();
				board.setDisable(true);
				setUncheckedButtonOpacities();
				winnerDeclared=true;

				ScoreTracker.player1Score+=1;
				ScoreTracker.writeToFile();


				return;

			}
		}
//		boolean deleteThis= hasWinningCombination(xButtons);
//		unClickedButtons.remove(Integer.parseInt(button.getText()));
		unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(button.getText())));

		if(xButtons.size()+oButtons.size()==9 && !winnerDeclared){
			System.out.println("DRAW");
			tieDialog();
			return;
		}
		/*
		Delete this later
		 */

		int time = (int)System.currentTimeMillis();

		Random random = new Random(time);
		int randomInt = random.nextInt();
		if(randomInt<0){
			randomInt = randomInt*-1;
		}
		int unClickedSize = unClickedButtons.size()-1;
		int randomIndex = randomInt%unClickedSize;

		int buttonNumber = unClickedButtons.get(randomIndex);

		switch(buttonNumber){
			case 1:
				one.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				one.setDisable(true);
				one.setOpacity(1);
				oButtons.add(Integer.parseInt(one.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(one.getText())));
				break;
			case 2:
				two.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				two.setDisable(true);
				two.setOpacity(1);
				oButtons.add(Integer.parseInt(two.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(two.getText())));

				break;
			case 3:
				three.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				three.setDisable(true);
				three.setOpacity(1);
				oButtons.add(Integer.parseInt(three.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(three.getText())));
				break;
			case 4:
				four.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				four.setDisable(true);
				four.setOpacity(1);
				oButtons.add(Integer.parseInt(four.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(four.getText())));
				break;
			case 5:
				five.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				five.setDisable(true);
				five.setOpacity(1);
				oButtons.add(Integer.parseInt(five.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(five.getText())));
				break;
			case 6:
				six.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				six.setDisable(true);
				six.setOpacity(1);
				oButtons.add(Integer.parseInt(six.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(six.getText())));

				break;
			case 7:
				seven.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				seven.setDisable(true);
				seven.setOpacity(1);
				oButtons.add(Integer.parseInt(seven.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(seven.getText())));
				break;
			case 8:
				eight.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				eight.setDisable(true);
				eight.setOpacity(1);
				oButtons.add(Integer.parseInt(eight.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(eight.getText())));
				break;
			case 9:
				nine.setGraphic((new ImageView(new Image("file:src/resources/O.png"))));
				nine.setDisable(true);
				nine.setOpacity(1);
				oButtons.add(Integer.parseInt(nine.getText()));
				unClickedButtons.remove(unClickedButtons.indexOf(Integer.parseInt(nine.getText())));
				break;

		}

		Collections.sort(oButtons);

		if(oButtons.size()>=3){

			if(hasWinningCombination(oButtons)) {
				System.out.println("WINNER IS O");
				loseDialog();
				board.setDisable(true);
				setUncheckedButtonOpacities();
				winnerDeclared=true;

				ScoreTracker.player2Score+=1;
				ScoreTracker.writeToFile();

				return;
			}
		}

	if(xButtons.size()+oButtons.size()==9 && !winnerDeclared){
		System.out.println("DRAW");
		tieDialog();
		return;
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
	
	/*2020.11.30 
	 * 
	 * restart the game when press the restrat button in the alert box.
	 */
	public void restart() {
	    try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("SinglePlayer.fxml"));
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
			for(int j =0; j<winstate.length;j++){
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
	
	/*11.30
	 * 
	 * pop up a winning dialog asking for quit or restart 
	 * when press quit, it returns to home page
	 * when press restart, it restart the game
	 * 
	 */
	public void winDialog() {
		Alert win = new Alert(AlertType.NONE,"Congratulation");
		win.setTitle("Confirmation");
		win.setContentText("You won the game, do you want to reset?");
		ButtonType restart = new ButtonType("Restart");
		ButtonType quit = new ButtonType("Quit");  
		win.getButtonTypes().setAll(restart,quit);
		Optional<ButtonType>result = win.showAndWait();
		if(result.isPresent() && result.get() == quit) {
				quit();
		}
		else if(result.isPresent() && result.get() == restart) {
			   restart();
			   }
		}
	public void loseDialog() {
		Alert lose = new Alert(AlertType.NONE,"Loser");
		lose.setTitle("Confirmation");
		lose.setContentText("You lost the game, do you want to reset?");
		ButtonType restart = new ButtonType("Restart");
		ButtonType quit = new ButtonType("Quit");  
		lose.getButtonTypes().setAll(restart,quit);
		Optional<ButtonType>result = lose.showAndWait();
		if(result.isPresent() && result.get() == quit) {
				quit();
		}
		else if(result.isPresent() && result.get() == restart) {
			   restart();
			   }
		}
	/*11.30
	 * 
	 * pop up a tie dialog asking for quit or restart  
	 * when press quit, it returns to home page
	 * when press restart, it restart the game
	 * 
	 */
	public void tieDialog() {
		Alert win = new Alert(AlertType.NONE, "Tie");
		win.setTitle("Comfirmation");
		win.setContentText("The game ends in a tie, do you want to reset?");
		ButtonType restart = new ButtonType("Restart");
		ButtonType quit = new ButtonType("Quit");
		win.getButtonTypes().setAll(restart, quit);
		Optional<ButtonType> result = win.showAndWait();
		if (result.isPresent() && result.get() == quit) {
			quit();
		} else if (result.isPresent() && result.get() == restart) {
			restart();
		}
		
		
	}
	public void setUncheckedButtonOpacities(){

		for(int i = 0; i< unClickedButtons.size(); i++){
			intToButton(unClickedButtons.get(i)).setOpacity(1);
		}
	}
	
	

}
