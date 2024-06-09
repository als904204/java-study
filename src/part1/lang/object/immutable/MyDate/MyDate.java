package part1.lang.object.immutable.MyDate;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(int month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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
