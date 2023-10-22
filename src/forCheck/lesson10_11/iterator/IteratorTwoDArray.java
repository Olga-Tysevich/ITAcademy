package forCheck.lesson10_11.iterator;

public class IteratorTwoDArray<T> {
    private final T[][] array;
    private int rowIndex = 0;
    private int columnIndex = 0;

    public IteratorTwoDArray(T[][] array) {
        this.array = array;
    }

    public T next() {

        if (columnIndex == array[rowIndex].length) {
            System.out.println();
            rowIndex++;
            columnIndex = 1;
        } else {
            columnIndex++;
        }
        return array[rowIndex][columnIndex - 1];
    }

    public boolean hasNext() {
        return rowIndex < array.length-1 || columnIndex < array[array.length-1].length;
    }
}