package thread.start;

import static util.MyLogger.log;

/**
 * 1. Thread 클래스를 상속받은 CounterThread 클래스 구현
 * 2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력해야 한다. (log()이용)
 * 3. main() 메서드에서 CounterThread 스레드 클래스를 만들고 실행하라
 *
 */
public class StartTest1Main {

    public static void main(String[] args) {

        CounterThread counterThread = new CounterThread();

        counterThread.start();

    }

    static class CounterThread extends Thread {


        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    log("value: "+i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
