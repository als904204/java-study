package thread.sync;

import static util.MyLogger.log;

public class SyncTest3BadMain {

    public static void main(String[] args) throws InterruptedException {

    }

    static class Immutable {

        private final int value;


        public Immutable(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
