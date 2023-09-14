package inProgress.lesson9;

public class CollectionsMain {
    public static void main(String[] args) {
        Stack<String> newStack = new Stack<>();

        newStack.push("A");
        newStack.push("J");
        newStack.push("B");
        newStack.push("C");
        newStack.push("D");
        newStack.push("E");
        newStack.push("A");

        System.out.println(newStack + "\n");
        newStack.pop();
        System.out.println(newStack + "\n");

        String maxEl = newStack.max();
        System.out.println("Max element: " + maxEl);
        System.out.println(newStack + "\n");
        String maxEl2 = newStack.max();
        System.out.println("Max element: " + maxEl2);
        System.out.println(newStack + "\n");
        String maxEl3 = newStack.max();
        System.out.println("Max element: " + maxEl3);
        System.out.println(newStack + "\n");
        String maxEl4 = newStack.max();
        System.out.println("Max element: " + maxEl4);
        System.out.println(newStack + "\n");
        String maxEl5 = newStack.max();
        System.out.println("Max element: " + maxEl5);
        System.out.println(newStack + "\n");
        String maxEl6 = newStack.max();
        System.out.println("Max element: " + maxEl6);
        System.out.println(newStack + "\n");
    }
}
