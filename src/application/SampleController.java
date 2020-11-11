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
	
	public void putCharacter() {
		
	
	}
	
 
}
