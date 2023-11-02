package checked.lesson16;

public class MaxValue implements Runnable{
    private int sumOfRow;
    private int sumOfColumn;

    public MaxValue(int sumOfRow, int sumOfColumn) {
        this.sumOfRow = sumOfRow;
        this.sumOfColumn = sumOfColumn;
    }

    @Override
    public void run() {
        if (sumOfRow > sumOfColumn) {
            System.out.println("The sum of the products of rows values is greater than the sum of the products of columns values: ");
            System.out.println("Sum of products of row values: " + sumOfRow);
            System.out.println("Sum of products of column values: " + sumOfColumn);
        } else {
            System.out.println("The the sum of the products of columns values is greater than sum of the products of rows values: ");
            System.out.println("Sum of products of row values: " + sumOfRow);
            System.out.println("Sum of products of column values: " + sumOfColumn);
        }
    }
}
