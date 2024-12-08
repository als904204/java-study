package thread.bounded;

/**
 * Buffer
 */
public interface BoundedQueue {

    /**
     * data save to buffer
     */
    void put(String data);

    /**
     * get data from buffer
     */
    String take();

}
