package lesson14_Thread_Runnable.task1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }

        FirstThread firstThread = new FirstThread();
        firstThread.setArray(array);
        SecondThread secondThread = new SecondThread();
        secondThread.setArray(array);
        System.out.println(Arrays.toString(array));
        firstThread.start();
        System.out.println("test");
        secondThread.start();
    }
}
