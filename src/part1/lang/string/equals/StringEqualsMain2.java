package part1.lang.string.equals;

public class StringEqualsMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello"); // x001
        String str2 = new String("hello"); // x002

        System.out.println(isSame(str1, str2));

        String str3 = "hello";
        String str4 = "hello";

        System.out.println(isSame((str3), str4));
    }

    private static boolean isSame(String s1, String s2) {
        // 개발자마다 문자열 생성을 new String, s = "asdf" 와 같이 다르게 할 수 있기때문에
        // 항상 ==가 아닌 equals 로 문자열을 비교해야한다
//        return s1 == s2;
        return s1.equals(s2);
    }
}
