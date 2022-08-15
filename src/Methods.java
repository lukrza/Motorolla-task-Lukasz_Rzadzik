import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Methods {

    int numberOfWordsToGuess;
    int numberOfGuessedWords;
    int whichColumnA;
    int whichColumnB;
    int attemptsLeft;
    String difficultyLevel;

    GameExceptions gameExceptions = new GameExceptions();
    List<String> listOfWords = new ArrayList<>();
    List<String> listTemporary = new ArrayList<>(); // coppy of list of Words A, from here I tak words to B
    String[] tabelRowA;
    String[] tabelRowB;
    String[][] tableWithGame;
    String[][] tableWithDiscoveredWords;

    public void loadingList() {
        try {
            File file = new File("src/Words.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listOfWords.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String chosingDiffLevel() {
        separator();

        System.out.println("Chose difficulty level (easy / hard): ");

        gameExceptions.difficultyLevel();
        difficultyLevel = gameExceptions.difficultyLevel;

        return difficultyLevel;
    }

    public void selectedDiffLevel(String difficultyLevel) {
        if (difficultyLevel.equals("easy")) {
            numberOfWordsToGuess = 4;
            attemptsLeft = 10;
        } else if (difficultyLevel.equals("hard")) {
            numberOfWordsToGuess = 8;
            attemptsLeft = 15;
        }
        tabelRowA = new String[numberOfWordsToGuess + 1];
        tabelRowB = new String[numberOfWordsToGuess + 1];
        tableWithGame = new String[2][numberOfWordsToGuess + 1];
        tableWithDiscoveredWords = new String[2][numberOfWordsToGuess + 1];
        separator2();
        System.out.println("Difficulty level: " + difficultyLevel.toLowerCase());
        System.out.println("Number of attempts available: " + attemptsLeft);
        System.out.println("Number of words to be discovered: " + numberOfWordsToGuess);
        separator2();
        System.out.println();
    }


    public void drawWordsToRowA() {
        Random randomA = new Random();
        for (int i = 0; i < numberOfWordsToGuess; i++) {
            String drawnWord = listOfWords.get(randomA.nextInt(listOfWords.size()));
            tabelRowA[i] = drawnWord;
            listTemporary.add(drawnWord); // from this list words are chosen to row B
            listOfWords.remove(drawnWord); // so the words are not repeating
        }
    }

    public void drawWordsToRowB() {
        Random randomB = new Random();
        for (int i = numberOfWordsToGuess; i > 0; i--) {
            int drawnIndexForB = randomB.nextInt(i);
            tabelRowB[numberOfWordsToGuess - i] = listTemporary.get(drawnIndexForB);
            listTemporary.remove(drawnIndexForB);
        }
    }
    public void tableBeforeGame() {
        tableWithGame[0][0] = "A ";
        tableWithGame[1][0] = "B ";
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < numberOfWordsToGuess + 1; j++) {
                tableWithGame[i][j] = "*";
            }
        }
    }

    public void printingTable(int p, boolean o) {
        separator3();
        if (o) {
            System.out.println("     Outcome: ");
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < p + 1; j++) {
                System.out.print(tableWithGame[i][j] + " ");
            }
            System.out.println();
        }
        separator3();


    }

    public void firstQuestionInGame(int a, int b) {
        if (a < b) {
            System.out.println("You have " + attemptsLeft + " attempts left and " + (numberOfWordsToGuess - numberOfGuessedWords) + " words to guess.");
            System.out.println();
        }

        System.out.println("1. Which word from row -A- you want to reveal (chose 1 to " + numberOfWordsToGuess + ")?");

        gameExceptions.whichColumn(numberOfWordsToGuess);
        whichColumnA = gameExceptions.columnIndex;
        tableWithGame[0][whichColumnA] = tabelRowA[whichColumnA - 1];
    }

    public void secondQuestionInGame() {
        System.out.println("2. Which word from row -B- you want to reveal (chose 1 to " + numberOfWordsToGuess + ")?");

        gameExceptions.whichColumn(numberOfWordsToGuess);
        whichColumnB = gameExceptions.columnIndex;
        tableWithGame[1][whichColumnB] = tabelRowB[whichColumnB - 1];
        if (tableWithGame[0][whichColumnA] == tableWithGame[1][whichColumnB]) {
        }
    }

    public void checkingGuesses() {
        // Row A
        if (tableWithDiscoveredWords[0][whichColumnA] == "+") {

        } else if (tableWithGame[0][whichColumnA] == tableWithGame[1][whichColumnB]) {
            tableWithDiscoveredWords[0][whichColumnA] = "+";
            numberOfGuessedWords += 1;
        } else
            tableWithGame[0][whichColumnA] = "*";

        // RowB
        if (tableWithDiscoveredWords[1][whichColumnB] == "+") {

        } else if (tableWithGame[0][whichColumnA] == tableWithGame[1][whichColumnB]) {
            tableWithDiscoveredWords[1][whichColumnB] = "+";
        } else
            tableWithGame[1][whichColumnB] = "*";
    }

   void separator() {
        System.out.println();
        System.out.println("][][][][][][][][][");
        System.out.println();

    }

    void separator2() {
        System.out.println("   - - - - - - - - - ");
    }

    void separator3() {
        System.out.println("-------------------");
    }

    void separator4(int p, int a, int b) {
        System.out.println();
        System.out.println();
        System.out.println("][    Round " + p + "    ][");
    }

    void separator5() {
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^");
    }

}
