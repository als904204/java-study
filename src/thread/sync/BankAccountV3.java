package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private int balance;


    public BankAccountV3(int initBalance) {
        this.balance = initBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        /**
         * 임계 영역 시작
         */
        synchronized (this) {
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : "+ balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : "+ balance);
                return false;
            }

            log("[검증 완료] 출금액 : " + amount + ", 잔액 : "+ balance);
            sleep(1000); // 출금 작업 1초라고 가정

            balance = balance - amount;
            log("[출금 완료] 출금액 : " + amount + ", 잔액 : "+ balance);
        }
        /**
         * 임계 영역 종료
         */

        log("거래 종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
