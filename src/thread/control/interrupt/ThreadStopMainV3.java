package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work1");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1=" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태를 변경하진 않는다
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2=" + Thread.currentThread().isInterrupted());

            try {

                /**
                 * Thread.sleep를 만나면 인터럽트 상태가 true 이므로
                 * 인터럽트 예외가 발생해버려
                 * 의도치않게 종료되어 버린다
                 */
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");

            } catch (InterruptedException e) {
                log("자원 정리 실패 -  자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3=" + Thread.currentThread().isInterrupted());
            }
            log("자원 정리");
        }

    }

}
