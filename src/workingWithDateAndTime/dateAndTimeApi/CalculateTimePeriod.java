package workingWithDateAndTime.dateAndTimeApi;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class CalculateTimePeriod {
    public static void main(String[] args) {
        // Get the current date
        LocalDate today = LocalDate.now();

        // New Year Date of 2025
        LocalDate newYearDayOfThisYear = LocalDate.of(today.getYear(), Month.DECEMBER, 31);

        // Calculate period left from current date to new year
        Period howLongForNewYear = Period.between(today, newYearDayOfThisYear);

        // Extraction the elements year, months and Dates
        int years = howLongForNewYear.getYears();
        int months = howLongForNewYear.getMonths();
        int days = howLongForNewYear.getDays();

        System.out.println("New year day of this year: " + newYearDayOfThisYear);
        System.out.println("How long for new year: " + howLongForNewYear);
        System.out.println("years: " + years);
        System.out.println("months: " + months);
        System.out.println("days: " + days);
    }
}
