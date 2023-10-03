package forCheck.lesson14.task1;

public class FirstThread extends Thread {
    int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void run() {
        System.out.println(getMax(array));
    }

    public int getMax(int[] array) {
        int max = array[0];
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
