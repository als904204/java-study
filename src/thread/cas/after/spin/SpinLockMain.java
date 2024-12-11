package thread.cas.after.spin;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLockGood spinLockgood = new SpinLockGood();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLockgood.lock();
                try {
                    log("비즈니스 로직 실행");
                    sleep(100); // 오래걸리는 비즈니스 로직에서는 스핀 락 사용 안좋음
                } finally {
                    spinLockgood.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }


}
