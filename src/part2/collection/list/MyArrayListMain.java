package part2.collection.list;

public class MyArrayListMain {

    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();

        myList.add("a");
        myList.add("b");
        myList.add("c");
        System.out.println(myList);

        System.out.println("addLast");
        myList.add(3, "addLast"); // O(1)
        System.out.println(myList);

        myList.add(0,"addFirst"); // O(n)
        System.out.println(myList);

        myList.remove(4);
        System.out.println(myList);        // O(1)

        myList.remove(0);           // O(n)
        System.out.println(myList);
    }

}
