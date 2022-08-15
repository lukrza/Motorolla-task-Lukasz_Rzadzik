public class Game extends Methods {
    int maxNumberOfAttempts;
    int numberOfUsedAttempts = 1;


    public void game() {

        loadingList();
        selectedDiffLevel(chosingDiffLevel());
        drawWordsToRowA();
        drawWordsToRowB();
        tableBeforeGame();
        CountingTime countingTime = new CountingTime();

        maxNumberOfAttempts = attemptsLeft;
        Thread countingTimeThread = new Thread(countingTime);
        countingTimeThread.start();
        for (int k = maxNumberOfAttempts; k > 0; k--) {
            separator4(numberOfUsedAttempts, k, maxNumberOfAttempts);
            printingTable(numberOfWordsToGuess, false);
            firstQuestionInGame(k, maxNumberOfAttempts);
            printingTable(numberOfWordsToGuess, false);
            secondQuestionInGame();
            printingTable(numberOfWordsToGuess, true);
            checkingGuesses();
            attemptsLeft -= 1;
            numberOfUsedAttempts += 1;

            if (numberOfGuessedWords == numberOfWordsToGuess) {
                break;
            }
        }
        if (numberOfGuessedWords == numberOfWordsToGuess) {
            numberOfUsedAttempts-=1;
            countingTimeThread.interrupt();
            int solutionTime = countingTime.getValue();

            System.out.println("Bravo, you've discovered all words! You needed " + numberOfUsedAttempts + " attempts and " + solutionTime + " seconds.");
            SavingResults savingResults = new SavingResults();

            savingResults.savingResults(solutionTime, numberOfUsedAttempts, difficultyLevel);


        } else if (attemptsLeft == 0) {
            System.out.println("The end, there are no attempts left!");
        }


    }
}

