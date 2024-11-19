package thread.volatile1;


import static java.lang.Thread.sleep;

import java.util.logging.Logger;

public class VolatileCountMain {

    private static final Logger log = Logger.getLogger(VolatileCountMain.class.getName());

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        log.info("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log.info("runFlag를 false로 변경 시도 ");
        task.runFlag = false;

        log.info("flag = " + task.runFlag + ", count = " + task.count + "in main()");


    }

    static class MyTask implements Runnable {


        boolean runFlag = true;
        long count;

        // volatile long getCount;

        @Override
        public void run() {
            log.info("task 시작");
            while (runFlag) {
                // runFlag 가 false 면 탈출
                count++;
                //1억번에 한번씩 출력
                if (count % 100_000_000 == 0) {
                    log.info("flag = " + runFlag + ", count = " + count + "in while()");

                }
            }
            log.info("while task 종료");
        }
    }

}
