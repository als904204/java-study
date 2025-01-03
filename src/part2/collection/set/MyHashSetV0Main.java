package part2.collection.set;

public class MyHashSetV0Main {

    public static void main(String[] args) {
        MyHashSetV0 hashSetV0 = new MyHashSetV0();

        hashSetV0.add(1);
        hashSetV0.add(1);
        hashSetV0.add(2);
        hashSetV0.add(3);

        System.out.println("hashSetV0 = " + hashSetV0);

        boolean contains = hashSetV0.contains(1);
        System.out.println("contains = " + contains);
    }

}
