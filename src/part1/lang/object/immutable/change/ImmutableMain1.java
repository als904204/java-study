package part1.lang.object.immutable.change;

public class ImmutableMain1 {

    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20);

        // 불변객체의 값을 변경하지 않고, 새로운 객체를 리턴해 사용한다
        System.out.println("obj1 = " + obj1.getValue());
        System.out.println("obj2 = " + obj2.getValue());

    }

}
