package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234";

        NewOrderService oleService = new NewOrderService();
        oleService.order(orderNo);
    }

}
