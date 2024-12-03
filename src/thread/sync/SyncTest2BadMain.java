package thread.sync;

import static util.MyLogger.log;

public class SyncTest2BadMain {

    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }

    static class MyCounter {

        /**
         * localValue 변수는 Count() 메서드의 지역변수기 때문에 동시성 문제 없음
         * 공유 자원이 아님
         */
        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue = localValue + 1;
            }
            log("결과 : " + localValue);
        }
    }

}
