package part1.lang.object.equals;

public class EqualsMainV1 {

    public static void main(String[] args) {

        // 동일성 동등성 비교

        UserV1 user1 = new UserV1("id-100"); // 0x100
        UserV1 user2 = new UserV1("id-100"); // 0x200

        System.out.println("identity = " + (user1 == user2));

        // Object class 가 제공하는 equals 는 "==" 연산자다
        // 그러므로 위와 동일하다

        /**
         * 동등성이라는 기준은 각각 다르다
         * 어떤 곳은 주민등록번호로
         * 어떤 곳은 전화번호로
         * 어떤 곳은 이메일로...
         * 이래서 equals 를 재정의 해야 한다.
         *
         *
         */
        System.out.println("equality = " + (user1.equals(user2)));


    }

}
