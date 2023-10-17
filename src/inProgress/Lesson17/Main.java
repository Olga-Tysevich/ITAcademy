package inProgress.Lesson17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String date1 = "JANUARY 1 2000";
        String date2 = "JANUARY 2 2020";
        String date3 = "OCTOBER 17 2023"; //290
        String date4 = "NOVEMBER 25 2019";

        System.out.println("The number of days since the beginning of the year is an odd number: " + isDateOdd(date1));
        System.out.println("The number of days since the beginning of the year is an odd number: " + isDateOdd(date2));
        System.out.println("The number of days since the beginning of the year is an odd number: " + isDateOdd(date3));
        System.out.println("The number of days since the beginning of the year is an odd number: " + isDateOdd(date4));

    }

    public static boolean isDateOdd(String date) {
        int dayNumber = LocalDate.parse(date.charAt(0) + date.substring(1).toLowerCase(),
                DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH)).getDayOfYear();
        System.out.println(date + " Day of year: " + dayNumber);
        return dayNumber % 2 != 0;
    }
}
