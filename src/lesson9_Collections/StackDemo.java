package lesson9_Collections;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stackString = new Stack<>();

        stackString.push("A");
        stackString.push("B");
        stackString.push("A");
        stackString.push("C");
        stackString.push("D");
        stackString.push("E");
        stackString.push("J");
        stackString.push("A");

        System.out.println(stackString + "\n");
        String deleteFirst = stackString.pop();
        System.out.println("Deleted element: " + deleteFirst);
        System.out.println(stackString + "\n");

        String testMaxElStr = "";
        while (testMaxElStr != null) {
            testMaxElStr = stackString.max();
            System.out.println("Max element: " + testMaxElStr);
            System.out.println(stackString + "\n");
            stackString.pop();
        }


        stackString.push("S");
        System.out.println(stackString + "\n");

        Stack<Integer> stackInt = new Stack<>();

        stackInt.push(1);
        stackInt.push(24);
        stackInt.push(3);
        stackInt.push(12);
        stackInt.push(24);
        stackInt.push(3);
        stackInt.push(8);
        stackInt.push(1);
        stackInt.push(15);

        Integer testMaxElInt = 1;
        while (testMaxElInt != null) {
            testMaxElInt = stackInt.max();
            System.out.println("Max element: " + testMaxElInt);
            System.out.println(stackInt + "\n");
            stackInt.pop();
        }

        Stack<Double> stackDouble = new Stack<>();

        stackDouble.push(1.6);
        stackDouble.push(1.0);
        stackDouble.push(12.5);
        stackDouble.push(36.4);
        stackDouble.push(8.2);
        stackDouble.push(1.5);
        stackDouble.push(15.6);

        Double testMaxElDouble = 0.0;
        while (testMaxElDouble != null) {
            testMaxElDouble = stackDouble.max();
            System.out.println("Max element: " + testMaxElDouble);
            System.out.println(stackDouble + "\n");
            stackDouble.pop();
        }

        Stack<String> stackWords = new Stack<>();

        stackWords.push("авантюрин");
        stackWords.push("абсурд");
        stackWords.push("азартный");
        stackWords.push("адский");
        stackWords.push("ювелир");
        stackWords.push("обжаловать");

        String testMaxElWord = "";
        while (testMaxElWord != null) {
            testMaxElWord = stackWords.max();
            System.out.println("Max element: " + testMaxElWord);
            System.out.println(stackWords + "\n");
            stackWords.pop();
        }

    }
}
