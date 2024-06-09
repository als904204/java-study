package part1.lang.string.immutable;

public class StringImmutable2 {

    public static void main(String[] args) {
        String str = "Hello";
        String str2 = str.concat(" there");

        // String 은 불변(Final)이기 때문에 변하지 않는다
        // 그러므로 새로 Return 된 객체를 사용해야한다
        System.out.println("str2 = " + str2);

    }

}
