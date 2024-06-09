package part1.lang.string.method;

public class StringInfoMain {

    public static void main(String[] args) {
        String str = "Hello, Java!";
        System.out.println("문자열 길이 : " + str.length());
        System.out.println("문자열 비어 있는지 : " + str.isEmpty());
        System.out.println("문자열 비어있거나 공백 : " + str.isBlank());
        System.out.println("문자열 비어있거나 공백 : " + "   ".isBlank());

        char c = str.charAt(7);
        System.out.println("index of 7 : " + c);
    }

}
