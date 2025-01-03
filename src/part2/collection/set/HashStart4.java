package part2.collection.set;

import java.util.Arrays;

public class HashStart4 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        System.out.println("1 = " + hashIndex(1));
        System.out.println("1 = " + hashIndex(2));
        System.out.println("1 = " + hashIndex(5));
        System.out.println("1 = " + hashIndex(8));
        System.out.println("1 = " + hashIndex(14));
        System.out.println("1 = " + hashIndex(99));

        Integer[] input = new Integer[CAPACITY];
        add(input, 1);
        add(input, 2);
        add(input, 5);
        add(input, 8);
        add(input, 14);
        add(input, 99);
        System.out.println(Arrays.toString(input));

        int target = 14;
        int found = hashIndex(target);
        System.out.println("found index :" + found);

        System.out.println("result : "+input[found]);

    }

    static void add(Integer[] input, int value) {
        int hashIdx = hashIndex(value);
        input[hashIdx] = value;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
