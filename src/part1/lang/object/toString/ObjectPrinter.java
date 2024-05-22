package part1.lang.object.toString;

public class ObjectPrinter {

    private ObjectPrinter() {}

    public static void print(Object object) {
        String string = "객체 정보 출력 : " + object.toString();
        System.out.println(string);
    }

}
