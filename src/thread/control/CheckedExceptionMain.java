package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {

    public static void main(String[] args){


    }

    static class CheckedRunnable implements Runnable {


        @Override
        public void run() {
            // you can you simply
            ThreadUtils.sleep(1000);
        }
    }

}
