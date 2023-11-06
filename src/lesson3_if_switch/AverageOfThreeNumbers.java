package lesson3_if_switch;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        //task #4
        double[] enteredNumbers = {0, 0, 0};
        boolean checkForDouble;
        String nameNumber;
        String[] nameNumberArray = {"первое", "второе", "третье"};

        System.out.println("Для определения среднего числа введите три разных числа: ");

        for (int i = 0; i < enteredNumbers.length; i++) {

            if (i == 0) {
                nameNumber = nameNumberArray[0];
            } else if (i == 1) {
                nameNumber = nameNumberArray[1];
            } else {
                nameNumber = nameNumberArray[2];
            }

            do {
                boolean notANumber = false;

                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите " + nameNumber + " число: ");

                checkForDouble = scanner.hasNextDouble();

                if (checkForDouble) {
                    enteredNumbers[i] = scanner.nextDouble();
                } else if (scanner.hasNextLine()) {
                    try {
                        enteredNumbers[i] = Double.parseDouble(scanner.nextLine());
                        checkForDouble = true;
                    } catch (NumberFormatException exceptionNotANumber) {
                        System.out.println("Вы ввели не число! Введите " + nameNumber + " число!");
                        notANumber = true;
                    }
                }

                boolean numbersAreEqual = i == 1 && enteredNumbers[0] == enteredNumbers[1]
                                        || i == 2 && (enteredNumbers[0] == enteredNumbers[2] || enteredNumbers[1] == enteredNumbers[2]);

                if (numbersAreEqual && !notANumber) {
                    System.out.println("Вы ввели одинаковые числа! Введите разные числа!");
                    checkForDouble = false;
                }

            } while (!checkForDouble);

        }

        System.out.println("Вы ввели: " + enteredNumbers[0] + "; " + enteredNumbers[1] + "; " + enteredNumbers[2]);

        boolean conditionFirstNumberIsMiddle = enteredNumbers[1] < enteredNumbers[0] && enteredNumbers[0] < enteredNumbers[2]
                                            || enteredNumbers[1] > enteredNumbers[0] && enteredNumbers[0] > enteredNumbers[2];
        boolean conditionSecondNumberIsMiddle = enteredNumbers[0] < enteredNumbers[1] && enteredNumbers[1] < enteredNumbers[2]
                                             || enteredNumbers[0] > enteredNumbers[1] && enteredNumbers[1] > enteredNumbers[2];
        boolean conditionThirdNumberIsMiddle = enteredNumbers[0] < enteredNumbers[2] && enteredNumbers[2] < enteredNumbers[1]
                                            || enteredNumbers[0] > enteredNumbers[2] && enteredNumbers[2] > enteredNumbers[1];

        String[] messageResultNumbersComparison = {"Средним является ", " число. Его значение: "};

        if (conditionFirstNumberIsMiddle) {
            System.out.println(messageResultNumbersComparison[0] + nameNumberArray[0] + messageResultNumbersComparison[1] + enteredNumbers[0]);
        } else if (conditionSecondNumberIsMiddle) {
            System.out.println(messageResultNumbersComparison[0] + nameNumberArray[1] + messageResultNumbersComparison[1] + enteredNumbers[1]);
        } else if (conditionThirdNumberIsMiddle) {
            System.out.println(messageResultNumbersComparison[0] + nameNumberArray[2] + messageResultNumbersComparison[1] + enteredNumbers[2]);
        }

    }
}
