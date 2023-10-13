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

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> sumOfRow = executor.submit(new SumOfRow(matrix));
        Future<Integer> sumOfColumn = executor.submit(new SumOfColumn(matrix, NUMBER_OF_COLUMN));

        while (true) {
            try {
                if (sumOfRow.isDone() && sumOfColumn.isDone()) {
                    executor.submit(new MaxValue(sumOfRow.get(), sumOfColumn.get()));
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();
    }
}
