package thread.control.printer;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");

        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요. (종료:q)");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                break;
            }

            printer.addJob(input);
        }
    }


    static class Printer implements Runnable {

        volatile boolean work = true;

        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        /**
         * 문제점
         * 3초마다 work 상태를 확인하기 때문에
         * 'q'를 입력받아도 3초뒤에 종료된다.
         * 이를 해결하기 위해 인터럽트를 이용하면 된다.
         */
        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작 : " + job + ", 대기문서 : " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
