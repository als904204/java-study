package part1.lang.string.immutable;

public class StringImmutable1 {

    public static void main(String[] args) {
        String str = "Hello";
        str.concat(" there");

        // String 은 불변(Final)이기 때문에 변하지 않는다
        System.out.println("str = " + str);
    }

}
