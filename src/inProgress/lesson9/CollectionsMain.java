package inProgress.lesson9;

public class CollectionsMain {
    public static void main(String[] args) {
//        Stack<String> stackString = new Stack<>();
//
//        stackString.push("A");
//        stackString.push("B");
//        stackString.push("C");
//        stackString.push("D");
//        stackString.push("E");
//        stackString.push("J");
//        stackString.push("A");

//        System.out.println(stackString + "\n");
//        String deleteFirst = stackString.pop();
//        System.out.println("Deleted element: " + deleteFirst);
//        System.out.println(stackString + "\n");
//
//        String testMaxElStr = "";
//        while (testMaxElStr != null) {
//            testMaxElStr = stackString.max();
//            System.out.println("Max element: " + testMaxElStr);
//            System.out.println(stackString + "\n");
//            stackString.pop();
//        }
//
//        stackString.push("S");
//        System.out.println(stackString);

        Stack<Integer> stackInt = new Stack<>();

        stackInt.push(1);
        stackInt.push(12);
        stackInt.push(3);
        stackInt.push(8);
        stackInt.push(1);
        stackInt.push(15);

        Integer testMaxElInt = 0;
        while (testMaxElInt != null) {
            testMaxElInt = stackInt.max();
            System.out.println("Max element: " + testMaxElInt);
            System.out.println(stackInt + "\n");
            stackInt.pop();
        }
    }
}
