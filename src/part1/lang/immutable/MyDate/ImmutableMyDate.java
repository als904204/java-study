package part1.lang.immutable.MyDate;

public class ImmutableMyDate {

    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    // 불변객체에서 무언가 값을 변경할 땐, with 로 변수명을 시작한다
    public ImmutableMyDate withYear(int newYear) {
        return new ImmutableMyDate(newYear, this.month, this.day);
    }

    public ImmutableMyDate withMonth(int newMonth) {
        return new ImmutableMyDate(this.year, newMonth, this.day);
    }

    public ImmutableMyDate withDay(int newDay) {
        return new ImmutableMyDate(this.year, this.month, newDay);
    }

    @Override
    public String toString() {
        return "MyDate{" +
            "year=" + year +
            ", month=" + month +
            ", day=" + day +
            '}';
    }

}
