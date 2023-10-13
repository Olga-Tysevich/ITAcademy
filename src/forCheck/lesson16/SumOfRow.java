package forCheck.lesson16;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SumOfRow implements Callable<Integer> {
    int[][] matrix;

    public SumOfRow(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() {
        return Arrays.stream(matrix).flatMapToInt(a -> Arrays.stream(a).reduce((b, c) -> b * c).stream()).reduce(Integer::sum).getAsInt();
    }
}
