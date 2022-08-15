public class Main {
// I wrote this project in IntelliJ IDEA and exported to github
    public static void main(String[] args) {
        GameExceptions gameExceptions = new GameExceptions();
        Methods methods = new Methods();


        String answer = "yes";

        while (answer.toLowerCase().equals("yes")) {
            Game game = new Game();
            game.game();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            methods.separator5();
            System.out.println("Do you want to play again? (yes / no): ");
            gameExceptions.answer();
            answer = gameExceptions.answer;

        }
        System.out.println("You finished the game");
        System.exit(0);
    }

}

