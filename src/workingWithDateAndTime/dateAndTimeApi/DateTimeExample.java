package workingWithDateAndTime.dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeExample {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("Local date: " + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("Local time: " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date time: " + localDateTime);

        LocalDate someDay = LocalDate.of(2000, Month.JUNE, 6);
        System.out.println("Someday: " + someDay);

        LocalTime someTime = LocalTime.of(23, 53);
        System.out.println("Sometime: " + someTime);

        LocalDateTime otherDateTime = LocalDateTime.of(2021, Month.MARCH, 4, 10, 51, 44);
        System.out.println("Other date time: " + otherDateTime);
    }
}
