package thread.sync.lock;

import static java.lang.Thread.sleep;

import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

public class LockSupportMainV2 {

    private static final Logger log = Logger.getLogger(LockSupportMainV2.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100);

        log.info("Thread-1 state : " + thread1.getState());

    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log.info("park 시작");
            LockSupport.parkNanos(2_000_000_00); // wating 상태
            log.info("park 종료, state:" + Thread.currentThread().getState());
            log.info("인터럽터 상태 : " + Thread.currentThread().isInterrupted());

        }
    }

}
