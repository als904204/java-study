package thread.cas.after.spin;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {

    private volatile boolean lock = false;

    /**
     * 락 사용 여부, 락 값 변경이 원자적이지 않아 멀티 스레드 동시성 문제가 발생한다
     */
    public void lock() {
        log("lock 흭득 시도");
        while (true) {
            // 1. 락 사용 여부
            if (!lock) {
                sleep(100);
                lock = true; // 락 흭득 성공
                break;
            }else{
                // 락 흭득할 때 까지 대(바쁜 대기)
                log("락 흭득 실패 - 스핀 대기");
            }
        }
        log("lock 흭득 완료");
    }

    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }

}
