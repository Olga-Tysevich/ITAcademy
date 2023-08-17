package lesson3;

public class NumberToClock {
    public static void main(String[] args) {
        //task #1
        /* Не знаю правильно ли поняла задачу:
        Если прошло 7 дней, то сейчас идет вторая неделя.
        Так же если прошли одни сутки, то сейчас идут вторые.
        Так нужно было выводить? Или в формате 1 неделя 1 день и т.д.?
        */
        int timeAsANumber = (int) (Math.random() * Math.pow(10, 7));
        System.out.println("Случайно заданное время в секундах: " + timeAsANumber);

        int valueSeconds = timeAsANumber % 60;
        int valueMinutes = (timeAsANumber / 60) % 60;
        int valueHours = (timeAsANumber / 3600) % 24;

        String nameSeconds = " секунда";
        String nameMinutes = " минута ";
        String nameHours = " час ";

        int[] arrayToCheckValueOfParameters = {valueSeconds, valueMinutes, valueHours};

        for (int valueOfParameter : arrayToCheckValueOfParameters) {

            boolean firstConditionToCheckValue = valueOfParameter % 10 == 0 || valueOfParameter % 10 >= 5
                                                 || (valueOfParameter % 100 >= 11 && valueOfParameter % 100 < 21);
            boolean secondConditionToCheckValue = valueOfParameter % 10 >= 2 && valueOfParameter % 10 < 5;

            if (firstConditionToCheckValue) {
                if (valueOfParameter == valueSeconds) {
                    nameSeconds = " секунд";
                }
                if (valueOfParameter == valueMinutes) {
                    nameMinutes = " минут ";
                }
                if (valueOfParameter == valueHours) {
                    nameHours = " часов ";
                }

            } else if (secondConditionToCheckValue) {
                if (valueOfParameter == valueSeconds) {
                    nameSeconds = " секунды";
                }
                if (valueOfParameter == valueMinutes) {
                    nameMinutes = " минуты ";
                }
                if (valueOfParameter == valueHours) {
                    nameHours = " часа ";
                }
            }
        }

        boolean valueHoursAndMinutesIsZero = valueHours == 0 && valueMinutes == 0;
        boolean valueHoursIsZero = valueHours == 0;

        if (valueHoursAndMinutesIsZero) {
            System.out.println("Время: " + valueSeconds + nameSeconds);
        } else if (valueHoursIsZero) {
            System.out.println("Время: " + valueMinutes + nameMinutes + valueSeconds + nameSeconds);
        } else {
            System.out.println("Время: " + valueHours + nameHours + valueMinutes + nameMinutes + valueSeconds + nameSeconds);
        }

        int valueDays = (timeAsANumber / (24 * 3600)) % 7;
        int valueWeeks = (timeAsANumber / (7 * 24 * 3600));

        String nameDays = "-е сутки ";

        boolean checkLastDigitsDays = (valueDays % 10) + 1 == 3;

        if (checkLastDigitsDays) {
            nameDays = "-и сутки ";
        }

        System.out.println("Идет: " + (valueWeeks + 1) + "-я неделя " + (valueDays + 1) + nameDays + valueHours + nameHours
                            + valueMinutes + nameMinutes + valueSeconds + nameSeconds);

    }
}
