import java.util.InputMismatchException;

public class GameExceptions {

    String difficultyLevel;
    String answer;
    String username;
    int columnIndex;
    boolean logicValue;

    public void difficultyLevel() {
        logicValue = false;
        while (!logicValue) {
            try {
                Scanner scanner = new Scanner();
                scanner.difficultyLevelScanner();
                difficultyLevel = scanner.difficultyLevel;
                logicValue = true;
            } catch (DifficultyLevelException e) {
                System.out.println("Enter the correct value.");
            }
        }
    }

    public void answer() {
        logicValue = false;
        while (!logicValue) {
            try {
                Scanner scanner = new Scanner();
                scanner.answerScanner();
                answer = scanner.answer;
                logicValue = true;
            } catch (AnswerException e) {
                System.out.println("Enter the correct value.");
            }
        }
    }


    public void whichColumn(int numberOfWordsToGuess) {
        logicValue = false;
        while (!logicValue) {
            try {
                Scanner scanner = new Scanner();
                scanner.columnIndexSkanner(numberOfWordsToGuess);
                columnIndex = scanner.columnIndex;
                logicValue = true;

            } catch (ColumnIndexException e) {
                System.out.println("Specify a value between " + 1 + " and " + numberOfWordsToGuess);
            } catch (InputMismatchException e) {
                System.out.println("Specify a value between " + 1 + " and " + numberOfWordsToGuess);
            }
        }
    }

    public void username() {
        logicValue = false;
        while (!logicValue) {
            try {
                Scanner scanner = new Scanner();
                scanner.usernameScanner();
                username = scanner.username;
                logicValue = true;
            } catch (UsernameException e) {
                System.out.println("Username must contains of 3 letters.");
            }
        }
    }


}

