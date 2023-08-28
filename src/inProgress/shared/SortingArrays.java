package inProgress.shared;

import java.util.Random;

public class SortingArrays {
    public static void main(String[] args) {
        int[] array = new int[100000];
        setArrayValues(array);
        int temp = 0;


//        bubble sort - 1000 -2.79
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length-i -1; j++) {
//                if (array[j + 1] <array[j]) {
//                    temp = array[j];
//                    array[j] = array[j+1];
//                    array[j + 1] = temp;
//                }
//            }
//        }


//        шейкерная - 1000 -2.32
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//            for (int j = array.length - i - 1; j > i; j--) {
//                if (array[j] < array[j - 1]) {
//                    temp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = temp;
//                }
//            }
//        }

//        Сортировка расчёской -1000 -2.135
//        double factor = 1.247;
//        int step = array.length - 1;
//
//        while (step >= 1) {
//            for (int i = 0; i + step < array.length; i++) {
//                if (array[i] > array[i + step]) {
//                    temp = array[i];
//                    array[i] = array[i + step];
//                    array[i + step] = temp;
//                }
//            }
//            step = (int) (step/factor);
//        }

//        Сортировка вставками -1000 -2.39
//        for (int i = 1; i < array.length; i++) {
//            int x = array[i];
//            int j = i;
//            while (j > 0 && array[j - 1] > x) {
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[j] = x;
//        }

//         Сортировка выбором -1000 -2.29
//
//        for (int i = 0; i != array.length - 1; i++) {
//            int minElement = array[i];
//            int minElementPosition = i;
//            for (int j = i; j < array.length; j++) {
//                if (array[j] < minElement) {
//                    minElement = array[j];
//                    minElementPosition = j;
//                }
//            }
//            temp = array[i];
//            array[i] = minElement;
//            array[minElementPosition] = temp;
//        }
//         Быстрая сортировка -1000 -2.104
//        sortArray(array, 0, array.length - 1);
//        printArray("Массив: ", array);

//     Заменить строки двумерного массива на столбцы
//        int[][] arrayTaskFive = setArrayTwoDValues(5, 5);
//        printArrayTwoD("Случайно заданная матрица: ", arrayTaskFive);
//        int maxAmountOfElements = 0;
//        int amountOfElements;
//
//
//        for (int[] arrayOneD : arrayTaskFive) {
//            amountOfElements = 0;
//            for (int element : arrayOneD) {
//                amountOfElements++;
//            }
//            if (maxAmountOfElements < amountOfElements) {
//                maxAmountOfElements = amountOfElements;
//            }
//        }
//
//        int[][] transposedArray = new int[maxAmountOfElements][];
//        int numberOfColumns = 0;
//        int rowInSourceArray;
//        int columnInSourceArray = 0;
//        int positionInCurrentRow = 0;
//
//
//        for (int k = 0; k < transposedArray.length; k++) {
//            for (int[] arrayRow : arrayTaskFive) {
//                while (positionInCurrentRow < arrayRow.length) {
//                    numberOfColumns++;
//                    break;
//                }
//            }
//            transposedArray[k] = new int[numberOfColumns];
//            rowInSourceArray = arrayTaskFive.length - 1;
//            while (rowInSourceArray >= 0 && numberOfColumns - 1 >= 0) {
//                if (columnInSourceArray > arrayTaskFive[rowInSourceArray].length - 1) {
//                    rowInSourceArray--;
//                    continue;
//                }
//                transposedArray[k][numberOfColumns - 1] = arrayTaskFive[rowInSourceArray][columnInSourceArray];
//                rowInSourceArray--;
//                numberOfColumns--;
//            }
//            numberOfColumns = 0;
//            columnInSourceArray++;
//            positionInCurrentRow++;
//        }
//
//        printArrayTwoD("Результат: ", transposedArray);

//        Arrays.sort(array);

//        int[] arraySecond = {-18, -22, -4, 16, -23, -11, -19, 17};

        sortArray(array, 0, array.length - 1);
//        printArray("Массив: ", array);

//        sortArraySecondWay(array, 0, array.length - 1);
        printArray("Массив: ", array);

    }

    private static void sortArraySecondWay(int[] array, int lowerBoundValue, int upperBoundValue) {
        if (lowerBoundValue >= upperBoundValue) {
            return;
        }
        int pivot = getPIndex(array, lowerBoundValue, upperBoundValue);

        sortArraySecondWay(array, lowerBoundValue, pivot - 1);
        sortArraySecondWay(array, pivot + 1, upperBoundValue);
    }

    private static int getPIndex(int[] array, int lowerBoundValue, int upperBoundValue) {
        int pivot = array[upperBoundValue];
        int pIndex = lowerBoundValue;
        for (int i = lowerBoundValue; i < upperBoundValue; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }
        swap(array, upperBoundValue, pIndex);
        return pIndex;
    }

    private static void swap(int[] array, int i, int pIndex) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;
    }

    private static void sortArray(int[] array, int lowerBoundValue, int upperBoundValue) {
        if (lowerBoundValue >= upperBoundValue) {
            return;
        }

        int lowIndex = lowerBoundValue;
        int highIndex = upperBoundValue;
        int borderIndex = lowerBoundValue + (upperBoundValue - lowerBoundValue) / 2;
        int borderElement = array[borderIndex];
        int temp;

        while (lowIndex <= highIndex) {
            while (array[lowIndex] < borderElement) {
                lowIndex++;
            }
            while (array[highIndex] > borderElement) {
                highIndex--;
            }
            if (lowIndex <= highIndex) {
                temp = array[highIndex];
                array[highIndex] = array[lowIndex];
                array[lowIndex] = temp;
                lowIndex++;
                highIndex--;
            }
        }

        if (lowerBoundValue < highIndex) {
            sortArray(array, lowerBoundValue, highIndex);
        }
        if (upperBoundValue > lowIndex) {
            sortArray(array, lowIndex, upperBoundValue);
        }
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
            array[i] = random.nextInt(50);
        }
    }

    private static int[][] setArrayTwoDValues(int numberOfRows, int numberOfColumns) {
        Random random = new Random();
        numberOfRows = random.nextInt(numberOfRows) + numberOfColumns;

        int[][] arrayTwoD = new int[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            numberOfColumns = random.nextInt(numberOfColumns) + numberOfRows;
            arrayTwoD[i] = new int[numberOfColumns];
            for (int j = 0; j < numberOfColumns; j++) {
                arrayTwoD[i][j] = random.nextInt(50) - 25;
            }
        }
        return arrayTwoD;
    }

    private static void printArray(String message, int[] array) {
        System.out.println(message);
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void printArrayTwoD(String message, int[][] arrayTwoD) {
        System.out.println(message);
        for (int[] arrayOneD : arrayTwoD) {
            for (int element : arrayOneD) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }
}
