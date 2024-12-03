package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance;


    public BankAccountV1(int initBalance) {
        this.balance = initBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금 금액보다 적으면

        log("[검증 시작] 출금액 : " + amount + ", 잔액 : "+ balance);
        if (balance < amount) {
            log("[검증 실패] 출금액 : " + amount + ", 잔액 : "+ balance);
            return false;
        }

        // 잔고가 출근 금액보다 많으면
        log("[검증 완료] 출금액 : " + amount + ", 잔액 : "+ balance);
        sleep(1000); // 출금 작업 1초라고 가정

        balance = balance - amount;
        log("[출금 완료] 출금액 : " + amount + ", 잔액 : "+ balance);


        log("거래 종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
