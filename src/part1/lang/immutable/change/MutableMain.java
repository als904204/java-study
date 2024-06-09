package part1.lang.immutable.change;

public class MutableMain {

    public static void main(String[] args) {
        MutableObj obj = new MutableObj(10);
        obj.add(20);

        // 계산 이후의 기존값(10)은 삭제가 되고 30이 되어 버림
        System.out.println("obj.getValue() = " + obj.getValue());

    }

}
