package forCheck.lesson16;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumOfColumn implements Callable<Integer> {
    private int[][] matrix;
    private final int NUMBER_OF_COLUMN;

    public SumOfColumn(int[][] matrix, int numberOfColumn) {
        this.matrix = matrix;
        NUMBER_OF_COLUMN = numberOfColumn;
    }

    @Override
    public Integer call() {
        return IntStream.range(0, NUMBER_OF_COLUMN).map(x -> Arrays.stream(matrix)
                .map(a -> a[x])
                .reduce((c, d) -> c * d).get()).sum();
    }

}
