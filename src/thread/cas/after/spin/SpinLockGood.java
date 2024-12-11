package thread.cas.after.spin;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLockGood {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    /**
     * 원자적으로 락 획득과 상태값을 변경한다.
     */
    public void lock() {
        log("락 획득 시도");
        while (!lock.compareAndSet(false, true)) {
        // 락을 획득할 때 까지 스핀 대기(바쁜 대기) 한다.
            log("락 획득 실패 - 스핀 대기");
        }
        log("락 획득 완료");
    }
    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }
}
