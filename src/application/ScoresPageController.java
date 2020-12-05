package application;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ScoresPageController extends Main{

    @FXML
    ListView scoreList;

    @FXML
    Button renderScoresButton;

    ObservableList<String> observableList = FXCollections.observableArrayList();

    public void renderScores(){

        //get a list of all files in ScoreFiles folder
        ArrayList<String> allFilesInScoreFiles = new ArrayList<>();

        File file = new File("./ScoreFiles");

        allFilesInScoreFiles.addAll(Arrays.asList(file.list()));

        Collections.sort(allFilesInScoreFiles);

        for (int i =0; i<allFilesInScoreFiles.size(); i++){

            if(allFilesInScoreFiles.get(i).contains("game")){
                String currentFile = allFilesInScoreFiles.get(i);


                //Read from fileNumberTracker and set counter
                try {

                    File gameHistoryFile = new File("./ScoreFiles/"+currentFile);
                    ArrayList dataInFile = new ArrayList();

                    Scanner scanner = new Scanner(gameHistoryFile);
                    while (scanner.hasNextLine()) {
                        dataInFile.add(scanner.nextLine());
//                System.out.println();
                    }
                    scanner.close();

                    String score = "Player 1: "+ dataInFile.get(0)+" \t\tScore: "+ dataInFile.get(1)
                            +" \tPlayer 2: "+ dataInFile.get(2) +" \t\tScore: " + dataInFile.get(3);
                    observableList.add(score);


                } catch (FileNotFoundException e) {
                    System.out.println("File Wasnt Found I guess");
                    e.printStackTrace();

                }


            }
//            System.out.println(allFilesInScoreFiles.get(i));
        }




        scoreList.setItems(observableList);
    }

    public void back(){
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root,600,600);
            rootStage.setScene(scene);
            rootStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



}
