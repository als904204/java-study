package thread.start;

public class HelloMain {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main() start");
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + " main() end");
    }

}
