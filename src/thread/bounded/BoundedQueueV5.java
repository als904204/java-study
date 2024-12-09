package thread.bounded;

import static util.MyLogger.log;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV5 implements BoundedQueue{

    private final Lock lock = new ReentrantLock();
    /**
     * 스레드 대기집합 공간 (락은 1개, 대기공간은 2개)
     */
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCond = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try{
            while (queue.size() == max) {
                log("[put] 큐가 다 가득 참, 생산자용 producerCond 대기  : ");
                try {
                    // 생산자는 생산자 대기공간에 들어간다
                    producerCond.await();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, 소비자용 consumerCond 호출");
            // 생산자가 다 차면, 소비자 대기공간을 깨운다
            consumerCond.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[take] 큐에 데이터 없음, 소비자 consumerCond 대기");
                try {
                    // 데이터가 없다면 소비자는 대기한다
                    consumerCond.await();
                    log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 흭득, producerCond 호출");
            // 생산자를 깨운다
            producerCond.signal();
            return data;
        } finally{
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
