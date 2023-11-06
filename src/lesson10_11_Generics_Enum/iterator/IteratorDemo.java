package lesson10_11_Generics_Enum.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Integer[][] twoDArray = {{1, 2, 3, 4, 5, 6, 7, 7}, {9, 8, 7, 6, 5, 4, 3, 2}, {9, 8, 7, 6, 5, 4, 3, 2}};
        IteratorTwoDArray<Integer> iteratorTwoDArray = new IteratorTwoDArray<>(twoDArray);

        int element;
        while (iteratorTwoDArray.hasNext()) {
            element = iteratorTwoDArray.next();
            System.out.print(element + ", ");
        }

    }
}
