package workingWithDateAndTime.dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeOperations {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        LocalDateTime futureDateTime = currentDateTime
                .plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4)
                .plusMinutes(5)
                .plusSeconds(6);

        boolean isBefore = futureDateTime.isBefore(currentDateTime);
        boolean isAfter = futureDateTime.isAfter(currentDateTime);

        System.out.println("currentDateTime: " + currentDateTime);
        System.out.println("today: " + today);
        System.out.println("now: " + now);
        System.out.println("futureDateTime: " + futureDateTime);

        System.out.println(isBefore);
        System.out.println(isAfter);
    }
}
