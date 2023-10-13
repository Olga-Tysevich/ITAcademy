package forCheck.lesson16;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {
    public static final int NUMBER_OF_ROW = 5;
    public static final int NUMBER_OF_COLUMN = 5;

    public static void main(String[] args) {
        int[][] matrix = Stream.generate(() -> new Random().ints(NUMBER_OF_COLUMN, 1, 10).toArray()).limit(NUMBER_OF_ROW)
                .toArray(int[][]::new);
        Arrays.stream(matrix).forEach(s -> System.out.println(Arrays.toString(s)));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> sumOfRow = executor.submit(new SumOfRow(matrix));
        Future<Integer> sumOfColumn = executor.submit(new SumOfColumn(matrix, NUMBER_OF_COLUMN));

        try {
            if (sumOfRow.get() > sumOfColumn.get()) {
                System.out.println("The sum of the products of rows values is greater than the sum of the products of columns values: ");
                System.out.println("Sum of products of row values: " + sumOfRow.get());
                System.out.println("Sum of products of column values: " + sumOfColumn.get());
            } else {
                System.out.println("The the sum of the products of columns values is greater than sum of the products of rows values: ");
                System.out.println("Sum of products of row values: " + sumOfRow.get());
                System.out.println("Sum of products of column values: " + sumOfColumn.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
