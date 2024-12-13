package thread.colliection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncListMain {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("data1");
        list.add("data2");
        list.add("data3");
        System.out.println(list.getClass().getSimpleName());
        System.out.println("list = " + list);
    }

}
