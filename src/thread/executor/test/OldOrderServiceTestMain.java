package thread.executor.test;

public class OldOrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234";

        OldOrderService oleService = new OldOrderService();
        oleService.order(orderNo);
    }

}
