package thread.start;

import static util.MyLogger.log;

public class StartTest3Main{

    public static void main(String[] args) {
        Print a = new Print("A", 1000);
        Print b = new Print("B", 1000);

        Thread threadA = new Thread(a, "Thread-A");
        Thread threadB = new Thread(b, "Thread-B");

        threadA.start();
        threadB.start();
    }


    static class Print implements Runnable {

        private String content;
        private int sleepMs;

        public Print(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
