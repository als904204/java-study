package part1.lang.immutable.MyDate;

public class MyDataMain {

    public static void main(String[] args) {
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = date1;

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        System.out.println("2025 -> date1");
        date1.setYear(2025);

        // date1만 변경했지만 date2까지 변경되어버린다. 사이드이펙트 발생
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("===================");

        ImmutableMyDate immutableMyDate1 = new ImmutableMyDate(2024, 1, 1);
        ImmutableMyDate immutableMyDate2 = immutableMyDate1.withYear( 2025);

        System.out.println("immutableMyDate1 = " + immutableMyDate1);
        System.out.println("immutableMyDate2 = " + immutableMyDate2);
    }

}
