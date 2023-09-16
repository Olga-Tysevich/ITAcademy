package inProgress.lesson10_11.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Integer[][] twoDArray = {{1, 2, 3, 4, 5, 6, 7}, {9, 8, 7, 6, 5, 4, 3, 2}};
        IteratorTwoDArray<Integer> newIteratorTwoDArray = new IteratorTwoDArray<>(twoDArray);

        int i;
        while (newIteratorTwoDArray.hasNext()) {
            i = newIteratorTwoDArray.next();
            System.out.print(i + ", ");
        }

    }
}
