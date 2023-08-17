package lesson3;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        //task #4
        double[] enteredNumbers = {0, 0, 0};
        boolean checkForDouble;
        String nameNumber = "";

        System.out.println("Для определения среднего числа введите три разных числа: ");

        for (int i = 0; i < enteredNumbers.length; i++) {
            if (i == 0) {
                nameNumber = "первое";
            } else if (i == 1) {
                nameNumber = "второе";
            } else {
                nameNumber = "третье";
            }

            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите " + nameNumber + " число: ");
                checkForDouble = scanner.hasNextDouble();
                if (checkForDouble) {
                    enteredNumbers[i] = scanner.nextDouble();
                } else if (scanner.hasNextLine()) {
                    try {
                        enteredNumbers[i] = Double.parseDouble(scanner.nextLine());
                        checkForDouble = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Вы ввели не число! Введите число!");
                    }
                }
                boolean numbersAreEqual = i == 1 && enteredNumbers[i - 1] == enteredNumbers[i]
                                          || i== 2 && (enteredNumbers[i - 2] == enteredNumbers[i] ||  enteredNumbers[i-1] == enteredNumbers[i]);
                if (numbersAreEqual) {
                    System.out.println("Вы ввели одинаковые числа! Введите разные числа!");
                    checkForDouble = false;

                }
            } while (checkForDouble != true);
        }

        System.out.println("Вы ввели: " + enteredNumbers[0] + "; " + enteredNumbers[1] + "; " + enteredNumbers[2]);

        boolean conditionFirstNumberIsMiddle = enteredNumbers[1] < enteredNumbers[0] && enteredNumbers[0] < enteredNumbers[2]
                                            || enteredNumbers[1] > enteredNumbers[0] && enteredNumbers[0] > enteredNumbers[2];
        boolean conditionSecondNumberIsMiddle = enteredNumbers[0] < enteredNumbers[1] && enteredNumbers[1] < enteredNumbers[2]
                                             || enteredNumbers[0] > enteredNumbers[1] && enteredNumbers[1] > enteredNumbers[2];
        boolean conditionThirdNumberIsMiddle = enteredNumbers[0] < enteredNumbers[2] && enteredNumbers[2] < enteredNumbers[1]
                                            || enteredNumbers[0] > enteredNumbers[2] && enteredNumbers[2] > enteredNumbers[1];

        String messageForFirstNumber = "Средним является первое введенное число. Его значение: ";
        String messageForSecondNumber = "Средним является второе введенное число. Его значение: ";
        String messageForThirdNumber = "Средним является третье введенное число. Его значение: ";

        if (conditionFirstNumberIsMiddle) {
            System.out.println(messageForFirstNumber + enteredNumbers[0]);
        } else if (conditionSecondNumberIsMiddle) {
            System.out.println(messageForSecondNumber + enteredNumbers[1]);
        } else if (conditionThirdNumberIsMiddle) {
            System.out.println(messageForThirdNumber + enteredNumbers[2]);
        }

    }
}
