package util;

import static util.MyLogger.log;

public abstract class ThreadUtils {

    /**
     * 매번 Thread.sleep() 사용할 때 마다 try catch 이용해야 하는 점을 여기서 런타임 예외로 잡음
     * @param mills
     */
    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }

    }


}
