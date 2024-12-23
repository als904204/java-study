package part2.collection.link;

public class MyLinkedListV2Main {

    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();

        // 마지막에 추가되므로 O(n)
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        // 첫번째 O(1)
        list.add(0, "d");
        list.remove(0);
        System.out.println(list);

        System.out.println("중간항목 추가삭제");
        list.add(1, "e");
        list.remove(1);
        System.out.println(list);
    }

}
