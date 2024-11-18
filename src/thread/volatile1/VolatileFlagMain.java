package thread.volatile1;


import static java.lang.Thread.sleep;

import java.util.logging.Logger;

public class VolatileFlagMain {

    private static final Logger log = Logger.getLogger(VolatileFlagMain.class.getName());

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        log.info("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log.info("runFlag를 false로 변경 시도 ");
        task.runFlag = false;

        log.info("runFlag = " + task.runFlag);
        log.info("main 종료");
    }

    static class MyTask implements Runnable {

        boolean runFlag = true;

        @Override
        public void run() {
            log.info("task 시작");
            while (runFlag) {
                // runFlag 가 false 면 탈출

            }
            log.info("task 종료");
        }
    }

}
