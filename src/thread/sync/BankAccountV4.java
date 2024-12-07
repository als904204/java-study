package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initBalance) {
        this.balance = initBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        lock.lock(); // ReentrantLock 을 이용하여 Lock 걸기
        try{
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : "+ balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : "+ balance);
                return false;
            }

            log("[검증 완료] 출금액 : " + amount + ", 잔액 : "+ balance);
            sleep(1000); // 출금 작업 1초라고 가정

            balance = balance - amount;
            log("[출금 완료] 출금액 : " + amount + ", 잔액 : "+ balance);

        }finally {
            // 예외가 발생하거나 return 이 되면 unlock 실행안되므로 반드시 finally 사용
            lock.unlock(); // ReentrantLock 을 이용하여 Lock 해제
        }


        log("거래 종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock(); // ReentrantLock 을 이용하여 Lock 걸기
        try{
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
