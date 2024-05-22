package part1.lang.object.toString;

public class ToStringMain2 {

    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("dog1", 1);
        Dog dog2 = new Dog("dog2", 10);

        System.out.println("1. 단순 toString() 호출");
        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        System.out.println();
        System.out.println("2. println 내부 toString() 호출");
        System.out.println(car);
        System.out.println(dog1);
        System.out.println(dog2);

        System.out.println();
        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1); // 메소드 재정의 해서 object 의 toString 보다 자식에서 재정의 된  toString() 를 먼저 호출하낟
        ObjectPrinter.print(dog2);

        System.out.println();
        System.out.println("4. toString() 재정의된 객체의 참조값을 알고싶을 때");
        String refValue = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println("dog1.refValue = " + refValue);
    }

}
