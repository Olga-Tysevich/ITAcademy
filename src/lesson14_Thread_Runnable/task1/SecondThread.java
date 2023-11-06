package lesson14_Thread_Runnable.task1;

public class SecondThread extends Thread {
    int[] array;

    public void run() {
        System.out.println(getMax(array));
    }

    public int getMax(int[] array) {
        int min = array[0];
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
