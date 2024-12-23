package part2.collection.link;

public class MyLinkedListV3Main {

    public static void main(String[] args) {
        MyLinkedListV3<String> stringList = new MyLinkedListV3<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        System.out.println(stringList);

        MyLinkedListV3<Integer> integerLIst = new MyLinkedListV3<>();
        integerLIst.add(1);
        integerLIst.add(2);
        integerLIst.add(3);
        System.out.println(integerLIst);
    }

}
