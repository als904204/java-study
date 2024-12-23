package part2.collection.link;


public class MyLinkedListV1Main {

    public static void main(String[] args) {
        MyLinkedListV1 myList = new MyLinkedListV1();

        myList.add("a");
        myList.add("b");
        myList.add("c");
        System.out.println(myList);
        System.out.println("===기능사용===");
        System.out.println("list.size()=" + myList.size());
        System.out.println("myList.get(1) = " + myList.get(1));
        System.out.println("myList.indexOf(\"c\") = " + myList.indexOf("c"));
        System.out.println("myList.set(2,\"z\") = " + myList.set(2, "z"));
        System.out.println(myList);

        System.out.println("===범위초과===");
        myList.add("d");
        System.out.println(myList);
        myList.add("e");
        myList.add("f");
        System.out.println(myList);
    }

}
