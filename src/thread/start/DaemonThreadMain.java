package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 Thread 설정
        daemonThread.start();

        // 사용자 쓰레드가 모두 종료되어 버려서 데몬 쓰레드가 실행중이여도 프로그램이 끝나버린다
        System.out.println(Thread.currentThread().getName() + " : main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : run()");

            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " : end()");


        }
    }

}
