package workingWithDateAndTime.dateAndTimeApi;

import java.time.Duration;
import java.time.Instant;

public class DurationsAndInstants {
    public static void main(String[] args) {
        // Getting the current timestamp
        Instant timeStamp = Instant.now();
        System.out.println("Timestamp: " + timeStamp);

        // Get the nan seconds from the last second
        int nanoSecondFromLastSecond = timeStamp.getNano();
        System.out.println("Nanon second from last second: " + nanoSecondFromLastSecond);

        // Set the duration to three hours
        Duration threeHours = Duration.ofHours(3);
        System.out.println("Three hours: " + threeHours);

        // Substract 15 minutes from 3 hours and get the remaining as seconds
        long minutesAsSeconds = threeHours.minusMinutes(15).getSeconds();
        System.out.println("Seconds: " + minutesAsSeconds);

        long secondsAsMinutes = Duration.ofSeconds(minutesAsSeconds).toMinutes();
        System.out.println("Minutes: " + secondsAsMinutes);
    }
}
