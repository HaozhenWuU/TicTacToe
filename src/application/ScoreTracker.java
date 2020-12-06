package application;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class ScoreTracker {

    public static String player1Name="default";
    public static int player1Score=0;
    public static String player2Name="default 2";
    public static int player2Score= 0;

    public static void writeToFile(){

        String currentPath = System.getProperty("user.dir");

        ArrayList dataInFileNumberFile = new ArrayList();
        ArrayList dataToWrite = new ArrayList();

        dataToWrite.add(player1Name);
        dataToWrite.add(player1Score);
        dataToWrite.add(player2Name);
        dataToWrite.add(player2Score);

        //Read from fileNumberTracker and set counter
        try {

            File file = new File("./ScoreFiles/fileNumberTracker.txt");
            if(!file.exists()){
                initScoreFiles();
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                dataInFileNumberFile.add(scanner.nextLine());
//                System.out.println();
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            System.out.println("File Wasnt Found I guess");
            e.printStackTrace();

        }

        //write to file with new generated file name
        try {
            //Create a New file
//            file:src/resources/O.png
            String filePath = "./ScoreFiles/game"+dataInFileNumberFile.get(0)+".txt";
            File scoreFile = new File(filePath);
            if (scoreFile.createNewFile()) {
                System.out.println("File created: " + scoreFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            int countOfSleeps=0;
            while(!scoreFile.exists() && countOfSleeps<10){
                Thread.sleep(1000);
                countOfSleeps = countOfSleeps+1;

            }
            //Write to the new file
            BufferedWriter scoreWriter = new BufferedWriter(new FileWriter(scoreFile.getPath(), true));
            while(dataToWrite.size()>0){
                scoreWriter.write(dataToWrite.get(0).toString());
                scoreWriter.newLine();
                dataToWrite.remove(0);
            }
            scoreWriter.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //write to fileNumberTracker with updated file number
        try {
            BufferedWriter scoreWriter = new BufferedWriter(new FileWriter("./ScoreFiles/fileNumberTracker.txt", false));
            String fileNumber = (String)dataInFileNumberFile.get(0);
            int fileNumberAsInt = Integer.parseInt(fileNumber);
            fileNumberAsInt=fileNumberAsInt+1;
            fileNumber=Integer.toString(fileNumberAsInt);
            scoreWriter.write(fileNumber);
            scoreWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    private static void initScoreFiles(){
        try {

            //Create a New file
            File dir = new File("ScoreFiles");
            dir.mkdir();
            int countOfSleeps = 0;
            //Keep sleeping until the directory exists
            while(!dir.exists() && countOfSleeps<10){
                Thread.sleep(1000);
                countOfSleeps = countOfSleeps+1;
            }
            File scoreFile = new File("./ScoreFiles/fileNumberTracker.txt");
            if (scoreFile.createNewFile()) {
                System.out.println("File created: " + scoreFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            //Wait until fileNumber tracker exists, up to 10 seconds
            countOfSleeps =0;
            while(!scoreFile.exists()&& countOfSleeps<10){
                Thread.sleep(1000);
            }
            System.out.println("this is the number of sleeps"+countOfSleeps);
            System.out.println("this is scoreFileExists");
            System.out.println(scoreFile.exists());
            System.out.println("-----------------------");
            //Write to the new file
            BufferedWriter scoreWriter = new BufferedWriter(new FileWriter(scoreFile.getPath(), true));
            scoreWriter.write("0");
            scoreWriter.newLine();
            scoreWriter.close();

        } catch (IOException | InterruptedException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
    }



}
