package checked.lesson17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<String> date = List.of("JANUARY 1 2000", "JANUARY 2 2020", "OCTOBER 17 2023", "NOVEMBER 25 2019");
        date.forEach(s ->System.out.println("The number of days since the beginning of the year is an odd number: " + isDateOdd(s)));
    }

    public static boolean isDateOdd(String date) {
        try {
            int dayNumber = LocalDate.parse(date.charAt(0) + date.substring(1).toLowerCase(),
                    DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH)).getDayOfYear();
            System.out.println(date + " Day of year: " + dayNumber);
            return dayNumber % 2 != 0;
        } catch (DateTimeParseException parseException){
            System.out.println(parseException.getMessage());
        }
        return false;
    }
}
