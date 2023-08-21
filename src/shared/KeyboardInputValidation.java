package shared;

import java.util.Scanner;

public class KeyboardInputValidation {
    private int integerResult;
    private boolean checkForNumber = false;


    public int getIntegerWithSizeAndSign(int size, boolean exactMatch, String numberSign) {
        int integer = 0;
        String message = "не менее ", messageTwo = ":";
        if (exactMatch) {
            message = "";
        }
        if (size % 10 == 1 && exactMatch) {
            messageTwo = "а:";
        } else if (size % 10 >= 2 && size % 10 < 5 && exactMatch) {
            messageTwo = "ы:";
        } else if (!exactMatch && size % 10 == 1) {
            messageTwo = "ы:";
        }
        switch (numberSign) {
            case "positive" -> {
                System.out.println("Необходимо ввести целое положительное число, в котором " + message + size + " цифр" + messageTwo);
                integer = getPositiveInteger();
            }
            case "negative" -> {
                System.out.println("Необходимо ввести целое отрицательное число, в котором " + message + size + " цифр" + messageTwo);
                integer = getNegativeInteger();
            }
            case "any" -> {
                System.out.println("Необходимо ввести целое число, в котором " + message + size + " цифр" + messageTwo);
                integer = getInteger();
            }
        }

        while (true) {
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
                integer = getIntegerWithSizeAndSign(size, exactMatch, numberSign);
            }
        }
    }

    public int getPositiveInteger() {

        int positiveNumber = getInteger("positive");
        while (positiveNumber < 0) {
            System.out.println("Вы ввели отрицательное число!");
            positiveNumber = getInteger("positive");
        }
        return positiveNumber;
    }

    public int getNegativeInteger() {
        int negativeNumber = getInteger("negative");
        while (negativeNumber > 0) {
            System.out.println("Вы ввели положительное число!");
            negativeNumber = getInteger("negative");
        }
        return negativeNumber;
    }

    public int getAnyInteger() {
        System.out.print("Введите целое число: ");
        return getInteger();
    }

    private int getInteger(String numberSign) {
        if (numberSign.equals("positive")) {
            System.out.print("Введите целое положительное число: ");
            getInteger();
        } else if (numberSign.equals("negative")) {
            System.out.print("Введите целое отрицательное число: ");
            getInteger();
        }
        return integerResult;
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
                        System.out.print("Введено не число! Введите число: ");
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
