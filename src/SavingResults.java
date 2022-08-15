import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SavingResults {


    GameExceptions gameExceptions = new GameExceptions();
    Date date = new Date();

    String answer;
    String username;
    String path;

    public void savingResults(int resolutionTime, int numberOfUsedAttempts, String difficultyLevel) {
        System.out.println();
        System.out.println("Do you want to save your score? (yes / no)");
        gameExceptions.answer();
        answer = gameExceptions.answer;
        if (answer.equals("yes")) {
            System.out.println("Enter username (3 letters)");
            gameExceptions.username();
            username = gameExceptions.username;
            String time = Integer.toString(resolutionTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String date = dateFormat.format(this.date);
            String attempts = Integer.toString(numberOfUsedAttempts);


            try {
                if (difficultyLevel.equals("easy")) {
                    path = "src/Scores-easy.txt";
                } else if (difficultyLevel.equals("hard")) {
                    path = "src/Scores-hard.txt";
                }
                FileWriter fileWriter = new FileWriter(path, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(username);
                bufferedWriter.write(" | ");
                bufferedWriter.write(date);
                bufferedWriter.write(" | ");
                bufferedWriter.write(time);
                bufferedWriter.write(" (seconds) | ");
                bufferedWriter.write(attempts);
                bufferedWriter.write(" (attempts) | ");
                bufferedWriter.newLine();
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("Error saving the file");
            }
        } else {

        }
    }

}
