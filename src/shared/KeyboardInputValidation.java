package shared;

import java.util.Scanner;

public class KeyboardInputValidation {
    private int integerResult;
    private boolean checkForNumber = false;

    public int getIntegerWithSizeAndSign(int size, boolean exactMatch, String... numberSign) {
        int counterOfDigit = 0;
        int integer = 0;
        int integerTemp;

        try {
            if (numberSign[0].equals("positive")) {
                System.out.println("Необходимо ввести целое положительное число, в котором не менее " + size + " цифр:");
                integer = getPositiveInteger();
            } else if (numberSign[0].equals("negative")) {
                System.out.println("Необходимо ввести целое отрицательное число, в котором не менее " + size + " цифр:");
                integer = getInteger("negative");
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Необходимо ввести целое число, в котором не менее " + size + " цифр:");
            integer = getInteger();
        }
        while (true) {
            integerTemp = integer;
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
        if (positiveNumber < 0) {
            System.out.println("Вы ввели отрицательное число!");
            positiveNumber = getInteger("positive");
        }
        return positiveNumber;
    }

    public int getInteger(String... numberSign) {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                if (numberSign[0].equals("positive")) {
                    System.out.print("Введите целое положительное число: ");
                } else if (numberSign[0].equals("negative")) {
                    System.out.print("Введите целое отрицательное число: ");
                }
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.out.print("Введите целое число: ");
            }

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
            System.out.println("Ваше число слишком длинное! Число должно быть не меньше (-2³¹) и не больше (2³¹ -1)");
            checkForNumber = false;
        } else {
            checkForNumber = true;
        }
        return checkForNumber;
    }
}
