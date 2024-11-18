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

        /**
         * main 쓰레드의 flag 는 false 로 업데이트 됨
         * 하지만, OS는 성능 향상을 위해 매번 메모리에서 읽는게 아닌
         * CPU마다 캐시데 데이터를 쌓아둠
         * 그러므로 다음과 같이 됨
         * CPU1(main) cache -> flag = false 이 부분만 변경 될 뿐 실제 메모리엔 변경이 안됨
         * CPU2(task) cache -> flag = true
         *
         *
         */
    }

    static class MyTask implements Runnable {

        // 캐시 메모리 사용하지 않고 항상 메인 메모리에 접근하도록 설정
        volatile boolean runFlag = true;

        // 캐시 메모리에만 접근
        //boolean runFlag = true;

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
