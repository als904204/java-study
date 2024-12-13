package thread.colliection.simple;

import static util.ThreadUtils.sleep;

import java.util.Arrays;

public class SyncList implements SimpleList{

    private static final int CAPACITY = 5;

    private Object[] data;
    private int size = 0;

    public SyncList() {
        this.data = new Object[CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object object) {
        data[size] = object;
        sleep(100); // 멀티스레드 문제를 쉽게 확인하는 코드
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return data[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(data, size)) + " size=" + size + ", capacity="
            + data.length;
    }
}
