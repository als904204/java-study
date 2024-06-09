package part1.lang.string.equals;

public class StringEqualsMain1 {

    public static void main(String[] args) {
        String str1 = new String("hello"); // x001
        String str2 = new String("hello"); // x002

        // 주소값을 비교한다
        System.out.println("new String() == 비교 : " + (str1 == str2));

        // 실제 변수에 할당되어있는 값 비교한다
        System.out.println("new String() .equals() 비교 : " + (str1.equals(str2)));

        System.out.println("===================");
        String str3 = "hello";
        String str4 = "hello";

        // new String 과는 다르게 주소 값 == 비교가 True 다.
        // 왜냐하면 리터럴을 사용하는 경우
        // 자바는 메모리 효율성과 성능을 위해 문자열 풀을 사용한다
        // 즉 같은 문자열이 있을 경우 새로운 주소값에 또 생성하는게 아닌
        // 문자열 풀에서 "hello" 문자를 가진 인스턴스를 찾는다
        // 찾은 인스턴스의 주소값을 참조한다
        System.out.println("리터럴 == 비교 : " + (str3 == str4));
        System.out.println("리터럴 equals 비교 : " + (str1.equals(str3)));
    }

}
