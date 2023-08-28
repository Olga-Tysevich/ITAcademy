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

        for (int element : array) {
            if (element > 0) {
                numberOfPositiveElements++;
            }
            if (element < 0) {
                numberOfNegativeElements++;
            }
        }

        System.out.println();

        int[] arrayOfPositiveElements = new int[numberOfPositiveElements];
        int[] arrayOfNegativeElements = new int[numberOfNegativeElements];

        int positionPositiveArray = 0;
        int positionNegativeArray = 0;

        for (int element : array) {
            if (element > 0) {
                arrayOfPositiveElements[positionPositiveArray] = element;
                positionPositiveArray++;
            } else if (element < 0) {
                arrayOfNegativeElements[positionNegativeArray] = element;
                positionNegativeArray++;
            }
        }

        printArray("Массив с положительными элементами: ", arrayOfPositiveElements);
        printArray("Массив с отрицательными элементами: ", arrayOfNegativeElements);

        System.out.println("\n");

        //task #2
        System.out.println("Задание #2");
        int[] arrayTaskTwo = new int[15];
        int counterOfIdenticalElements = 0;
        int[] arrayOfUniqueElements;

        setArrayValues(arrayTaskTwo);
        printArray("Случайно заданный массив: ", arrayTaskTwo);

        for (int i = 0; i < arrayTaskTwo.length - 1; i++) {
            for (int j = i + 1; j < arrayTaskTwo.length; j++) {

                if (arrayTaskTwo[i] == arrayTaskTwo[j]) {
                    counterOfIdenticalElements++;
                    break;
                }

            }
        }

        System.out.println("Количество повторяющихся элементов: " + counterOfIdenticalElements);

        arrayOfUniqueElements = new int[arrayTaskTwo.length - counterOfIdenticalElements];
        int positionArrayOfUniqueElements = 0;

        for (int element : arrayTaskTwo) {

            for (int i = 0; i < positionArrayOfUniqueElements || i == 0; i++) {

                if (arrayOfUniqueElements[i] != element) {
                    arrayOfUniqueElements[positionArrayOfUniqueElements] = element;
                } else if (positionArrayOfUniqueElements == 0) {
                    break;
                } else {
                    positionArrayOfUniqueElements--;
                    break;
                }

            }

            positionArrayOfUniqueElements++;
            if (positionArrayOfUniqueElements == arrayOfUniqueElements.length) {
                break;
            }

        }

        printArray("Массив с уникальными элементами: ", arrayOfUniqueElements);
        System.out.println("\n");

        //task #3
        System.out.println("Задание #3");
        int[] firstArrayTaskThree = new int[10];
        int[] secondArrayTaskThree = new int[8];
        int[] concatenatedArray;

        setSortedArrayValues(firstArrayTaskThree);
        setSortedArrayValues(secondArrayTaskThree);

        printArray("Первый сортированный массив: ", firstArrayTaskThree);
        printArray("Второй сортированный массив: ", secondArrayTaskThree);

        System.out.println("Размер первого массива: " + getArraySize(firstArrayTaskThree));
        System.out.println("Размер второго массива: " + getArraySize(secondArrayTaskThree));

        int sizeOfConcatenatedArray = getArraySize(firstArrayTaskThree) + getArraySize(secondArrayTaskThree);
        System.out.println("Требуемый размер объединенного массива: " + sizeOfConcatenatedArray);

        concatenatedArray = new int[sizeOfConcatenatedArray];
        int currentPositionFirstArray = 0;
        int currentPositionSecondArray = 0;

        for (int i = 0; i < sizeOfConcatenatedArray; i++) {
            if (currentPositionFirstArray > firstArrayTaskThree.length - 1) {
                concatenatedArray[i] = secondArrayTaskThree[currentPositionSecondArray];
                currentPositionSecondArray++;
            } else if (currentPositionSecondArray > secondArrayTaskThree.length - 1) {
                concatenatedArray[i] = firstArrayTaskThree[currentPositionFirstArray];
                currentPositionFirstArray++;
            } else if (firstArrayTaskThree[currentPositionFirstArray] < secondArrayTaskThree[currentPositionSecondArray]) {
                concatenatedArray[i] = firstArrayTaskThree[currentPositionFirstArray];
                currentPositionFirstArray++;
            } else {
                concatenatedArray[i] = secondArrayTaskThree[currentPositionSecondArray];
                currentPositionSecondArray++;
            }
        }

        printArray("Объединенный упорядоченный массив: ", concatenatedArray);
        System.out.println("\n");

        //task #4
        System.out.println("Задание #4");
        int[][] arrayTaskFour = setTwoDArrayValues(6, 10);

        printTwoDArray("Случайно заданная матрица: ", arrayTaskFour);
        System.out.println();

        int maxSumOfElements = 0;
        int numberOfRow = 0;

        for (int i = 0; i < arrayTaskFour.length; i++) {

            int sumOfElements = 0;

            for (int j = 0; j < arrayTaskFour[i].length; j++) {
                sumOfElements += arrayTaskFour[i][j];
            }

            System.out.println("Сумма элементов в строке номер: " + (i + 1) + " равна: " + sumOfElements);

            if (maxSumOfElements < sumOfElements) {
                maxSumOfElements = sumOfElements;
                numberOfRow = i + 1;
            }

        }

        System.out.println("Максимальная сумма элементов равна: " + maxSumOfElements + " и находится в строке: " + numberOfRow);
        System.out.println("\n");

        //task #5
        System.out.println("Задание #5");
        int[][] arrayTaskFive = setTwoDArrayValues(5, 7);

        printTwoDArray("Случайно заданная матрица: ", arrayTaskFive);

        int amountOfElements = 0;
        int amountOfRows = 0;

        for (int[] oneDArray : arrayTaskFive) {
            for (int element : oneDArray) {
                amountOfElements++;
            }
            amountOfRows++;
        }

        int amountOfColumns = amountOfElements / amountOfRows;

        System.out.println("\nВ исходной матрице строк: " + amountOfRows + ", столбцов: " + amountOfColumns);

        int[][] transposedArray = new int[amountOfColumns][amountOfRows];

        for (int i = 0; i < arrayTaskFive.length; i++) {
            for (int j = 0; j < arrayTaskFive[i].length; j++) {
                transposedArray[j][i] = arrayTaskFive[i][j];
            }
        }

        System.out.println("В конечной матрице строк: " + amountOfColumns + ", столбцов: " + amountOfRows + "\n");
        printTwoDArray("Транспонированная матрица: ", transposedArray);
        System.out.println("\n");

        //task #6
        System.out.println("Задание #6");
        int[] arrayTaskSix = new int[10];

        setArrayValues(arrayTaskSix);

        printArray("Исходный массив: ", arrayTaskSix);

        int temp;

        for (int i = 0; i < arrayTaskSix.length / 2; i++) {
            temp = arrayTaskSix[i];
            arrayTaskSix[i] = arrayTaskSix[arrayTaskSix.length - 1 - i];
            arrayTaskSix[arrayTaskSix.length - 1 - i] = temp;
        }

        printArray("Перевернутый массив: ", arrayTaskSix);

    }


    private static int getArraySize(int[] array) {
        int arraySize = 0;
        for (int element : array) {
            arraySize++;
        }
        return arraySize;
    }

    private static void setArrayValues(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) - 25;
        }
    }

    private static void setSortedArrayValues(int[] array) {
        Random random = new Random();
        int initialValue = random.nextInt(50) - 25;
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue + i;
        }
    }

    private static int[][] setTwoDArrayValues(int numberOfRows, int numberOfColumns) {
        Random random = new Random();

        int[][] arrayTwoD = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                arrayTwoD[i][j] = random.nextInt(50) - 25;
            }
        }

        return arrayTwoD;
    }

    private static void printArray(String anyMessageBeforeArray, int[] array) {
        System.out.println(anyMessageBeforeArray);

        for (int element : array) {
            System.out.printf("%4d ", element);
        }

        System.out.println();
    }

    private static void printTwoDArray(String anyMessageBeforeArray, int[][] arrayTwoD) {
        System.out.println(anyMessageBeforeArray);

        for (int[] arrayOneD : arrayTwoD) {
            for (int element : arrayOneD) {
                System.out.printf("%4d ", element);
            }
            System.out.println();
        }

    }

}
