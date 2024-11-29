package thread.start;

public class HelloThread extends Thread {

    /**
     * run() 호출이 아닌 반드시 start()메서드를 호출해야 한다
     * 그래야 별도의 스레드에서 run() 코드가 실행된다
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : run()");
    }



}
