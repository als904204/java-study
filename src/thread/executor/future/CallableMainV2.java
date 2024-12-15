package thread.executor.future;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit () 호출");
        // Future 이용해 Thread의 결과값을 반환할수있따.
        // Runnable 은 반환값 없음
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시반환 (),  future = " + future);

        log("future.get() [블로킹] 메소드 시작 -> main 스레드 WAITING ");
        Integer result = future.get();
        log("future.get() [블로킹] 메소드 완 -> main 스레드 RUNNABLE");

        log("result value = " + result);
        log("future 완료, future = " + future);
        es.shutdown();
    }

    static class MyCallable implements Callable<Integer> {


        @Override
        public Integer call() {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("Callable 완료");
            return value;
        }
    }

}
