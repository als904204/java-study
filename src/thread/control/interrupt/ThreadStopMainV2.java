package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work1");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1=" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            try{
                while (true) {
                    log("작업 중");
                    /**
                     * sleep 을 만나야만 인터럽트가 발생한다.
                     */
                    Thread.sleep(3000);
                }
            }catch (InterruptedException e) {
                // 외부에서 스레드 멈추라고 지시하면 인터럽트 예외가 발생한다
                log("work 쓰레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message=" + e.getMessage());
                log("state=" + Thread.currentThread().getState());

            }
            log("자원 정리");
        }

    }

}
