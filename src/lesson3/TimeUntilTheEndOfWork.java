package lesson3;

import java.util.Random;

public class TimeUntilTheEndOfWork {
    public static void main(String[] args) {
        //task #3
        Random random = new Random();

        int secondsOnTheScoreboard = random.nextInt(28801);
        int hoursUntilTheEndOfWork = secondsOnTheScoreboard / 3600;

        System.out.println("Секунд до конца работы: " + secondsOnTheScoreboard);
        if (secondsOnTheScoreboard == 0) {
            System.out.println("Рабочий день окончен");
        } else {
            switch (hoursUntilTheEndOfWork) {
                case 1:
                    System.out.println("Остался 1 час");
                    break;
                case 2, 3, 4:
                    System.out.println("Осталось " + hoursUntilTheEndOfWork + " часа");
                    break;
                case 5, 6, 7, 8:
                    System.out.println("Осталось " + hoursUntilTheEndOfWork + " часов");
                    break;
                default:
                    System.out.println("Осталось менее часа");
            }
        }

    }
}
