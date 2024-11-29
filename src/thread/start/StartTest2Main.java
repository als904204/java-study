package thread.start;

import static util.MyLogger.log;

public class StartTest2Main implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new StartTest2Main(), "counter");
        thread.start();

    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                log("value: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
