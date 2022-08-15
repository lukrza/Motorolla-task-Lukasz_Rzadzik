public class CountingTime implements Runnable {
    int solutionTime;

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {

            }
            solutionTime += 1;
        }
    }

    public int getValue() {
        return solutionTime;
    }

}
