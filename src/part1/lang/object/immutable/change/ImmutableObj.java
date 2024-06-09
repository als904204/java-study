package part1.lang.object.immutable.change;

public class ImmutableObj {

    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int addValue) {
        /**
         * 불변객체기 때문에 직접 값을 수정하면 안된다
         */
        // this.value = value + addValue;

        // 새로운 객체를 만들어 반환한다.
        // 불변도 유지하면서 새로운 결과도 만들 수 있다
        return new ImmutableObj(value + addValue);
    }

    public int getValue() {
        return value;
    }
}
