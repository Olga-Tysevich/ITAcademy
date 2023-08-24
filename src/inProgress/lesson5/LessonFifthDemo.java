package inProgress.lesson5;

import java.util.Random;

public class LessonFifthDemo {
    public static void main(String[] args) {


        //task #1
        System.out.println("Задание #1");
        int[] array = new int[10];
        int numberOfPositiveElements = 0;
        int numberOfNegativeElements = 0;

        setArrayValues(array);
        printArray("Случайно заданный массив: ", array);

        for (int k : array) {
            if (k > 0) {
                numberOfPositiveElements++;
            }
            if (k < 0) {
                numberOfNegativeElements++;
            }
        }

        System.out.println();

        int[] arrayOfPositiveElements = new int[numberOfPositiveElements];
        int[] arrayOfNegativeElements = new int[numberOfNegativeElements];

        int positionPositiveArray = 0;
        int positionNegativeArray = 0;

        for (int j : array) {
            if (j > 0) {
                arrayOfPositiveElements[positionPositiveArray] = j;
                positionPositiveArray++;
            } else if (j < 0) {
                arrayOfNegativeElements[positionNegativeArray] = j;
                positionNegativeArray++;
            }
        }

        printArray("Массив с положительными элементами: ", arrayOfPositiveElements);
        printArray("Массив с отрицательными элементами: ", arrayOfNegativeElements);

        System.out.println("\n");

        //task #2
        System.out.println("Задание #2");
        int[] arrayTaskTwo = new int[15];
        int elementMatchCounter = 0;
        int[] arrayOfUniqueElements;

        setArrayValues(arrayTaskTwo);
        printArray("Случайно заданный массив: ", arrayTaskTwo);

        for (int i = 0; i < arrayTaskTwo.length - 1; i++) {
            for (int j = i + 1; j < arrayTaskTwo.length; j++) {
                if (arrayTaskTwo[i] == arrayTaskTwo[j]) {
                    elementMatchCounter++;
                    break;
                }
            }
        }

        System.out.println("Количество повторяющихся элементов: " + elementMatchCounter);

        arrayOfUniqueElements = new int[arrayTaskTwo.length - elementMatchCounter];
        int positionArrayOfUniqueElements = 0;

        for (int i = 0; i < arrayTaskTwo.length - 1; i++) {
            for (int j = 0; j < positionArrayOfUniqueElements || j == 0; j++) {
                if (arrayOfUniqueElements[j] != arrayTaskTwo[i]) {
                    arrayOfUniqueElements[positionArrayOfUniqueElements] = arrayTaskTwo[i];
                } else {
                    arrayOfUniqueElements[positionArrayOfUniqueElements] = 0;
                    positionArrayOfUniqueElements--;
                    break;
                }
            }
            positionArrayOfUniqueElements++;
        }

        printArray("Массив с уникальными элементами: ", arrayOfUniqueElements);



    }

    private static void setArrayValues(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) - 25;
        }
    }

    private static void printArray(String message, int[] array) {
        System.out.println(message);
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
