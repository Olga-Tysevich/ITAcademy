package lesson3;

import java.util.Random;

public class DateFromThreeNumbers {
    public static void main(String[] args) {
        //task #2
        Random random = new Random();

        int numberOfYear = random.nextInt(150) + 1900;
        int numberOfMonth = random.nextInt(12) + 1;
        int numberOfDay = 0;
        int lastDayOfCurrentMonth = 0;

        boolean leapYear = numberOfYear % 4 == 0 && numberOfYear % 100 != 0 || numberOfYear % 400 == 0;
        String yearName;

        int lastDayOfFebruary;

        if (leapYear) {
            lastDayOfFebruary = 29;
            yearName = "високосный";
        } else {
            lastDayOfFebruary = 28;
            yearName = "не високосный";
        }

        switch (numberOfMonth) {
            case 1, 3, 5, 7, 8, 10, 12:
                lastDayOfCurrentMonth = 31;
                numberOfDay = random.nextInt(31) + 1;
                break;
            case 2:
                lastDayOfCurrentMonth = lastDayOfFebruary;
                numberOfDay = random.nextInt(lastDayOfFebruary) + 1;
                break;
            case 4, 6, 9, 11:
                lastDayOfCurrentMonth = 30;
                numberOfDay = random.nextInt(30) + 1;
                break;
        }

        System.out.println("Введенная дата: " + String.format("%02d", numberOfDay) + "." + String.format("%02d", numberOfMonth) + "." + numberOfYear);
        if (numberOfMonth == 2) {
            System.out.println(numberOfYear + " год - " + yearName + ". В феврале " + lastDayOfFebruary + " дней");
        }

        boolean changeOfMonth = numberOfDay == lastDayOfCurrentMonth && numberOfMonth != 12;
        boolean changeOfYear = numberOfDay == 31 && numberOfMonth == 12;

        if (numberOfDay < lastDayOfCurrentMonth) {
            ++numberOfDay;
        }
        if (changeOfYear) {
            numberOfDay = 1;
            numberOfMonth = 1;
            ++numberOfYear;
        } else if (changeOfMonth) {
            numberOfDay = 1;
            ++numberOfMonth;
        }

        System.out.println("Дата следующего дня: " + String.format("%02d", numberOfDay) + "." + String.format("%02d", numberOfMonth) + "." + numberOfYear);

    }
}
