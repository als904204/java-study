package part1.lang.string;

public class StringConcatMain {

    public static void main(String[] args) {
        String a = "hello";
        String b = " java";

        String result1 = a.concat(b);

        /* 사실상 x001 + x002 인데 즉 주소값을 더하기인데 어떻게 문자열이 합쳐지는 것일까?*/
        // 문자열은 너무 자주 사용되기 때문에 자바 언어의 편의상 특별히 문자열 + 를 제공해준다
        String result2 = a + b;

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

}
