public class Scanner {

    String difficultyLevel;
    String answer;
    String username;
    int columnIndex;
    java.util.Scanner scanner = new java.util.Scanner(System.in);


    public void difficultyLevelScanner() throws DifficultyLevelException {

        difficultyLevel = scanner.nextLine().toLowerCase();

        if (difficultyLevel.equals("easy")) {

        } else if (difficultyLevel.equals("hard")) {

        } else {
            throw new DifficultyLevelException();
        }
    }

    public void answerScanner() throws AnswerException {

        answer = scanner.nextLine().toLowerCase();

        if (answer.equals("yes")) {

        } else if (answer.equals("no")) {

        } else {
            throw new AnswerException();
        }
    }


    public void columnIndexSkanner(int numberOfWordsToGuess) throws ColumnIndexException {

        columnIndex = scanner.nextInt();

        if (columnIndex < 1) {
            throw new ColumnIndexException();
        } else if (columnIndex > numberOfWordsToGuess) {
            throw new ColumnIndexException();
        } else {
        }
    }


    public void usernameScanner() throws UsernameException {

        username = scanner.nextLine().toLowerCase();

        if (username.length() == 3) {

        } else {
            throw new UsernameException();
        }
    }
}
