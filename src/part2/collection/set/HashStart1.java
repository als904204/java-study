package part2.collection.set;

import java.util.Arrays;

public class HashStart1 {

    public static void main(String[] args) {
        Integer[] inputArr = new Integer[4];
        inputArr[0] = 1;
        inputArr[1] = 2;
        inputArr[2] = 5;
        inputArr[3] = 8;

        System.out.println(Arrays.toString(inputArr));

        int searchValue = 8;

        // O(n)
        for (Integer inputValue : inputArr) {
            if (inputValue == searchValue) {
                System.out.println(inputValue);
            }
        }
    }

}
