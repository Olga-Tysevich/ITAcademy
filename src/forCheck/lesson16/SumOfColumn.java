package forCheck.lesson16;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumOfColumn implements Callable<Integer> {
    private int[][] matrix;

    public SumOfColumn(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() {
        return IntStream.range(0, matrix.length).map(x -> Arrays.stream(matrix)
                .map(a -> a[x])
                .reduce((c, d) -> c * d).get()).sum();
    }

}
