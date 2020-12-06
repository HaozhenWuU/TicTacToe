package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

public class MultiPlayerController extends Main{
	

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
@FXML TextField player1TextField;
@FXML TextField player2TextField;
@FXML Label player1TextLabel;
@FXML Label player2TextLabel;

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
		System.out.println("button was clicked");

//		player2TextField.setText("THIS SHOULD BE HERE");

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
					ScoreTracker.player1Score= ScoreTracker.player1Score+1;
					int dummy =1;
					System.out.println("WINNER IS X");
					setUncheckedButtonOpacities();
					board.setDisable(true);
					winDialog();
					winnerDeclared=true;


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
					ScoreTracker.player2Score= ScoreTracker.player2Score+1;
					System.out.println("WINNER IS O");
					setUncheckedButtonOpacities();
					board.setDisable(true);
					winDialog2();
					winnerDeclared=true;

					

				}
			}
		}
		if(xButtons.size()+oButtons.size()==9 && !winnerDeclared){
			tieDialog();
			System.out.println("DRAW");
		}



	}
	//sets the current scene back to the home page
	public void quit(){
		ScoreTracker.writeToFile();
		ScoreTracker.player1Score=0;
		ScoreTracker.player2Score=0;
		ScoreTracker.player1Name = "Default 1";
		ScoreTracker.player2Name = "Default 2";
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
	 * restart the game when press the restart button in the alert box.
	 */
	public void restart() {
	    try {

//	    	resetBoard();
            Pane root = (Pane) FXMLLoader.load(this.getClass().getResource("MultiPlayer.fxml"));

//          root.getChildren().
            Scene scene = new Scene(root,600,600);

            rootStage.setScene(scene);
            
            

//			player1TextLabel.textProperty().bind(player1Name);
//			player2TextLabel.textProperty().bind(player2Name);
//			player1Name.set(ScoreTracker.player1Name);
//			player2Name.set(ScoreTracker.player2Name);
//			setNames();

            rootStage.show();


//            Thread.sleep(5000);



        } catch(Exception e) {
            e.printStackTrace();
        }


	}
	
	
	public void backHandler() {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("GameMode.fxml"));
			Scene scene = new Scene(root, 600, 600);
			rootStage.setScene(scene);
			rootStage.show();
		} catch (Exception e) {
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

	

	private final StringProperty player1Name = new SimpleStringProperty();
	private final StringProperty player2Name = new SimpleStringProperty();

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
//		player1TextField.setText("THIS IS HERE IDK WHY");
	}


	public void setNames(){
		player1TextField.setText(ScoreTracker.player1Name);
		player2TextField.setText(ScoreTracker.player2Name);


		System.out.println("Player 1 text field after reset: "+player1TextField.getText());

		System.out.println("Player 2 text field after reset: "+player2TextField.getText());
	}

	//the event handler for the quit option
//	public void quitHandler(){quit();};

	/* The event handler for the quit option.
	 * When the player choose to quit the game,
	 * a warning would present to confirm if
	 * the player wants to quit.
	 *
	 */
	public void quitHandler(){
		Alert warn = new Alert(AlertType.WARNING);
		warn.setHeaderText("Warning!");
		warn.setContentText("Do you want to quit the game?");
		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		warn.getButtonTypes().setAll(yes, no);
		Optional<ButtonType> result = warn.showAndWait();
		if (result.isPresent() && result.get() == yes) {
			quit();
		} else if (result.isPresent() && result.get() == no) {
			warn.close();
		}
    }

	public void updatePlayer1String(){
		ScoreTracker.player1Name=player1TextField.getText();
		player1TextLabel.textProperty().set(ScoreTracker.player1Name);

	}
	public void updatePlayer2String(){
		ScoreTracker.player2Name=player2TextField.getText();
		player2TextLabel.textProperty().set(ScoreTracker.player2Name);
	}


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

	
	/*11.30
	 * 
	 * pop up a winning dialog asking for quit or restart 
	 * when press quit, it returns to home page
	 * when press restart, it restart the game
	 * 
	 */
	public void winDialog() {
		Alert win = new Alert(AlertType.NONE,"Congratulation");
		win.setTitle("Comfirmation");
		win.setContentText("Player " + ScoreTracker.player1Name + " has won the game, do you want to reset?");
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
	public void winDialog2() {
		Alert win = new Alert(AlertType.NONE,"Congratulation");
		win.setTitle("Comfirmation");
		win.setContentText("Player "+ ScoreTracker.player2Name + " has won the game, do you want to reset?");
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
		ArrayList<Integer> unClickedButtons = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		ArrayList<Integer> checkButtons = new ArrayList<Integer>();
		checkButtons.addAll(xButtons);
		checkButtons.addAll(oButtons);
		for(int i = 0; i < checkButtons.size(); i++)
		{
			unClickedButtons.remove(unClickedButtons.indexOf(checkButtons.get(i)));
		}
		for(int i = 0; i< unClickedButtons.size(); i++){
			intToButton(unClickedButtons.get(i)).setOpacity(1);
		}
	}

	public void resetBoard(){
		ArrayList<Integer> allButtons = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for(int i = 0; i< allButtons.size(); i++){
			intToButton(allButtons.get(i)).setGraphic(null);
			intToButton(allButtons.get(i)).setDisable(true);
			intToButton(allButtons.get(i)).setDisable(false);

//			intToButton(allButtons.get(i)).disableProperty().set(true);
//			intToButton(allButtons.get(i)).disableProperty().set(false);
//			intToButton(allButtons.get(i)).setStyle(null);

			System.out.println("Disabled property: "+intToButton(allButtons.get(i)).disableProperty().getValue());

		}
	}
	

}
