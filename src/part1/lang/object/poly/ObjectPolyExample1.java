package part1.lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Car car = new Car();
        Dog dog = new Dog();

        action(car);
        action(dog);
    }

    private static void action(Object o) {
        // o.move()     Object 는 부모 클래스로, 자식 클래스의 메소드 사용 불가
        // o.sound()    Object 는 부모 클래스로, 자식 클래스의 메소드 사용 불가

        // 만약 부모 클래스가 자식 클래스의 메소드를 사용해야 한다면,
        // 다운 캐스팅 해야 함
        if (o instanceof Car car) {
            car.move();
        }else if(o instanceof Dog dog) {
            dog.sound();
        }
    }

}
