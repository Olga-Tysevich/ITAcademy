package forCheck.lesson14.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SaveAsThread extends Thread {
    int[] array;
    final File file;

    public SaveAsThread(int arraySize, File file) {
        this.file = file;
        setArrayValues(arraySize);
    }

    @Override
    public void run() {
        writeArrayToFile(array);
    }

    private void writeArrayToFile(int[] array) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            System.out.println(Arrays.toString(array));
            synchronized (file) {
                for (int j : array) {
                    fileWriter.write(j + " ");
                    System.out.println("Tread: " + Thread.currentThread().getName() + " write number: " + j);
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void setArrayValues(int arraySize) {
        Random random = new Random();
        array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
    }
}
