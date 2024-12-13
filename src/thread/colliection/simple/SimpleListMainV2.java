package thread.colliection.simple;

import static util.MyLogger.log;

public class SimpleListMainV2 {

    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
        //test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        // A save
        Runnable a = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1 : list.add(A)");
            }
        };

        Runnable b = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2 : list.add(B)");
            }
        };

        Thread threadA = new Thread(a,"Thread-1");
        Thread threadB = new Thread(b,"Thread-2");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        log(list);

    }

}
