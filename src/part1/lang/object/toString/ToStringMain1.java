package part1.lang.object.toString;

public class ToStringMain1 {

    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // 결과는 같다. 왜냐하면 string 은 부모 클래스의 toString()을 사용하기 때문
        System.out.println("object = " + object);
        System.out.println("string = " + string);
    }

}
