package thread.cas.after;

import static util.MyLogger.log;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMain1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        System.out.println(atomicInteger.get());

        int resultValue1 = incrementAndGet(atomicInteger);

    }

    /**
     * 바꾸려는 값이, 원하는 값이 아니라면 실패한다
     */
    static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get(); // 읽었을 때 0
            log("getValue" + getValue);
            // 값을 읽고, 0이라면 getValue + 1 해라
            // 만약 thread2가 먼저 update해버렸다면 누군가가 값을 바꿨으므로 업데이트 안한다
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
        } while (!result);
        return getValue + 1;
    }

}
