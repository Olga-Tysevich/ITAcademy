package inProgress.lesson4;

import inProgress.lesson4.shared.KeyboardInputValidation;

import java.math.*;
import java.text.*;


public class LessonFourthHomework {
    public static void main(String[] args) {
        KeyboardInputValidation keyboardInputValidation = new KeyboardInputValidation();
        NumberFormat numberFormat = NumberFormat.getInstance();

        //task #1
        System.out.println("Задание #1");
        int variableOfFirstTask = 2;
        int currentVariable = 0;

        for (int i = 0; currentVariable < 512; i++) {
            currentVariable = (int) Math.pow(variableOfFirstTask, i);
            System.out.print(currentVariable + " ");
        }
        System.out.println("\n");

        //task #2
        System.out.println("Задание #2");
        int variableOfSecondTask = keyboardInputValidation.getIntegerWithSizeAndSign(2, false,"positive");
        int variableOfSecondTaskToPrint = variableOfSecondTask;
        int currentDigitOfSecondTask;
        int sumOfDigits = 0;
        int multiplicationOfDigits = 1;

        while (variableOfSecondTask != 0) {
            currentDigitOfSecondTask = variableOfSecondTask % 10;
            sumOfDigits = sumOfDigits + currentDigitOfSecondTask;
            multiplicationOfDigits = multiplicationOfDigits * currentDigitOfSecondTask;
            variableOfSecondTask = variableOfSecondTask / 10;
        }
        System.out.println("Сумма цифр числа: " + variableOfSecondTaskToPrint + " равна: " + Math.abs(sumOfDigits));
        System.out.println("Произведение цифр числа: " + variableOfSecondTaskToPrint + " равно: "
                            + numberFormat.format(Math.abs(multiplicationOfDigits)) + "\n");

        //task #3
        System.out.println("Задание #3");
        int variableOfThirdTask = keyboardInputValidation.getAnyInteger();


        int maxDigit = 0, positionOfMaxDigit = 1;
        int currentDigit, currentPosition = 1;
        int printInteger = variableOfThirdTask;

        while (variableOfThirdTask != 0) {
            currentDigit = Math.abs(variableOfThirdTask) % 10;
            if (maxDigit < currentDigit) {
                maxDigit = currentDigit;
                positionOfMaxDigit = currentPosition;
            }
            variableOfThirdTask = variableOfThirdTask / 10;
            currentPosition++;
        }

        System.out.println("Максимальная цифра числа: " + printInteger + " равна: "
                + maxDigit + " и находится в позиции " + positionOfMaxDigit + "\n");

        //task #4
        System.out.println("Задание #4");
        int variableOfFourthTask = keyboardInputValidation.getAnyInteger();

        if (variableOfFourthTask < 0) {
            System.out.println("Отрицательное число не является натуральным! Оно будет преобразовано в положительное!");
            variableOfFourthTask = Math.abs(variableOfFourthTask);
        }

        BigInteger factorialOfANumber = BigInteger.valueOf(1);
        BigInteger counterInitialValue = BigInteger.valueOf(1);
        BigInteger increment = BigInteger.valueOf(1);

        for (int i = 1; i <= variableOfFourthTask; i++) {
            factorialOfANumber = factorialOfANumber.multiply(counterInitialValue);
            counterInitialValue = counterInitialValue.add(increment);
        }

        System.out.println("Факториал числа " + variableOfFourthTask + " равен: " + factorialOfANumber + "\n");

        //task #5
        System.out.println("Задание #5");
        int firstNumber = 1;
        int secondNumber = 0;
        int currentNumber;

        System.out.print(secondNumber + " " + firstNumber + " ");

        for (int i = 3; i < 11; i++) {
            currentNumber = firstNumber + secondNumber;
            secondNumber = firstNumber;
            firstNumber = currentNumber;
            System.out.print(currentNumber + " ");
        }

        System.out.println("\n");

        //task #6
        System.out.println("Задание #6");
        int numberOfUnits = 100000;
        int numberOfUnitsTemp;
        int counterOfExcludedUnits = 0;

        while (numberOfUnits != 0) {
            numberOfUnitsTemp = numberOfUnits;

            while (numberOfUnitsTemp != 0) {

                if (numberOfUnitsTemp % 10 == 4 || numberOfUnitsTemp % 100 == 13) {
                    counterOfExcludedUnits += 1;
                    break;
                }

                numberOfUnitsTemp = numberOfUnitsTemp / 10;
            }

            numberOfUnits--;

        }

        System.out.println("Необходимо исключить " + numberFormat.format(counterOfExcludedUnits) + " единиц боевой техники \n");

        //task #7
        System.out.println("Задание #7");
        int luckyTicketCounter = 0;
        int firstThreeDigits, lastThreeDigits;

        for (int i = 1; i <= 999999; i++) {
            int sumOfFirstThreeDigits = 0;
            int sumOfLastThreeDigits = 0;
            lastThreeDigits = i % 1000;
            firstThreeDigits = i / 1000;
            while (firstThreeDigits != 0 || lastThreeDigits != 0) {
                sumOfFirstThreeDigits = sumOfFirstThreeDigits + firstThreeDigits % 10;
                firstThreeDigits = firstThreeDigits / 10;
                sumOfLastThreeDigits = sumOfLastThreeDigits + lastThreeDigits % 10;
                lastThreeDigits = lastThreeDigits / 10;
            }

            if (sumOfFirstThreeDigits == sumOfLastThreeDigits) {
                luckyTicketCounter++;
            }
        }

        System.out.println("В рулоне " + numberFormat.format(luckyTicketCounter) + " счасливый билет" + "\n");

        //task #8
        System.out.println("Задание #8");
        int numberOfShelves = 50000;
        int numberOfShelvesTemp;
        int counterOfDefectiveProducts =0;

        while (numberOfShelves != 0){

            numberOfShelvesTemp = numberOfShelves;

            while (numberOfShelvesTemp !=0){

                if (numberOfShelvesTemp % 10 == 2){
                    counterOfDefectiveProducts++;
                    break;
                }

                numberOfShelvesTemp = numberOfShelvesTemp /10;
            }

            numberOfShelves--;
        }

        System.out.println("В бракованной партии " + numberFormat.format(counterOfDefectiveProducts) + " ошибочных табличек" + "\n");

        //task #9
        System.out.println("Задание #9");
        int variableOfNinthTask = keyboardInputValidation.getPositiveInteger();
        String message = " является простым\n";

        for (int j = 2; j < variableOfNinthTask; j++) {
            if (variableOfNinthTask % j == 0) {
                message = " не является простым\n";
                break;
            }
        }

        System.out.println("Число " + variableOfNinthTask + message);

        //task #10
        System.out.println("Задание #10");
        int counterOfSymmetricalCombinations = 0;

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (i / 10 == j % 10 && i % 10 == j / 10) {
                    counterOfSymmetricalCombinations++;
                }
            }
        }

        System.out.print("Число симметричных комбинаций: " + counterOfSymmetricalCombinations);

    }
}
