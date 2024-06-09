package part1.lang.string.method;

public class StringComparisonMain {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "Hello";
        String str3 = "Hi";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.startsWith("hel"));
    }

}
