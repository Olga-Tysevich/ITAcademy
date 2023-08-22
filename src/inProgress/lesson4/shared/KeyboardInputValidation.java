package inProgress.lesson4.shared;

import java.util.Scanner;

public class KeyboardInputValidation {
    private int integerResult;
    private boolean checkForNumber = false;


    public int getIntegerWithSizeAndSign(int size, boolean exactMatch, String numberSign) {
        int integer;
        String message;

        if (exactMatch) {
            message = "Необходимо ввести число, количество цифр в котором равно ";
        } else {
            message = "Необходимо ввести число, количество цифр в котором не менее ";
        }

        System.out.println(message + size + "!");
        integer = getInteger(numberSign);

        while (true){
            int counterOfDigit = 0;
            int integerTemp = integer;
            while (integerTemp != 0) {
                integerTemp = integerTemp / 10;
                counterOfDigit++;
            }

            if (counterOfDigit == size && exactMatch) {
                return integer;
            } else if (counterOfDigit >= size && !exactMatch) {
                return integer;
            } else {
                System.out.println("Вы ввели число в неверном формате! Введите корректное число!");
                System.out.println(message + size + "!");
                integer = getInteger(numberSign);
            }
        }
    }

    public int getInteger(String numberSign) {
        int integer;
        switch (numberSign) {
            case "positive" -> {
                System.out.print("Введите целое положительное число: ");
                integer = getInteger();
                while (integer < 0) {
                    System.out.println("Вы ввели отрицательное число!");
                    integer = getInteger("positive");
                }
                return integer;
            }
            case "negative" -> {
                System.out.print("Введите целое отрицательное число: ");
                integer = getInteger();
                while (integer > 0) {
                    System.out.println("Вы ввели положительное число!");
                    integer = getInteger("negative");
                }
                return integer;
            }
            case "any" -> {
                System.out.print("Введите целое число: ");
                return getInteger();
            }
        }
        return -1;
    }

    private int getInteger() {
        do {
            Scanner scanner = new Scanner(System.in);
            checkForNumber = scanner.hasNextInt();

            if (checkForNumber) {
                integerResult = scanner.nextInt();
            } else {
                checkForNumber = scanner.hasNextDouble();

                double tempNumber;
                if (checkForNumber) {
                    tempNumber = scanner.nextDouble();
                    checkForNumber = checkForIntegerSize(tempNumber);

                    if (checkForNumber) {
                        System.out.println("Введено не целое число! Введите целое число!");
                        checkForNumber = false;
                    }

                } else if (scanner.hasNextLine()) {

                    try {
                        tempNumber = Double.parseDouble(scanner.nextLine());
                        checkForIntegerSize(tempNumber);

                        if (checkForNumber) {
                            System.out.println("Введено не целое число! Введите целое число!");
                            checkForNumber = false;
                        }

                    } catch (NumberFormatException exceptionNotANumber) {
                        System.out.println("Введено не число! Введите число!");
                    }
                }
            }


        } while (!checkForNumber);
        System.out.println("Вы ввели число: " + integerResult);
        return integerResult;
    }

    private boolean checkForIntegerSize(double number) {
        if (number < -Math.pow(2, 31) || number > Math.pow(2, 31) - 1) {
            System.out.println("Ваше число слишком длинное! Число должно быть не меньше (-2³¹) и не больше (2³¹ -1)! Введите число: ");
            checkForNumber = false;
        } else {
            checkForNumber = true;
        }
        return checkForNumber;
    }

}


