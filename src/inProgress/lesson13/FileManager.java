package inProgress.lesson13;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {
    Random random;

    public void writeFile(String outputFilePath) {
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            for (int i = 0; i < 1000; i++) {
                random = new Random();
                fileWriter.write(random.nextInt(100001) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mergeAndSortFileData(String firstFilePath, String secondFilePath, String outputFilePath) {
        File out = new File(outputFilePath);
        ArrayList<Integer> arrayList = setValuesOfArrayList(new ArrayList<>(), firstFilePath);
        setValuesOfArrayList(arrayList, secondFilePath);
        Collections.sort(arrayList);
        try (FileWriter fileWriter = new FileWriter(out)) {
            while (arrayList.iterator().hasNext()) {
                fileWriter.write(arrayList.iterator().next() + "\n");
                arrayList.remove(arrayList.iterator().next());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createBinaryFile(String outputFilePath) {
        try (OutputStream outputStream = new FileOutputStream(outputFilePath)) {
            random = new Random();
            for (int i = 1; i < 31; i++) {
                outputStream.write(random.nextInt(101));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readBinaryFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            int a = inputStream.available();
            int currentNumber;
            int sum = 0;
            for (int i = 0; i < a; i++) {
                currentNumber = inputStream.read();
                System.out.print(currentNumber + " ");
                sum += currentNumber;
            }
            System.out.println("\n" + ((double) sum / 30));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<Integer> setValuesOfArrayList(ArrayList<Integer> arrayList, String filePath) {
        String str1;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((str1 = bufferedReader.readLine()) != null) {
                arrayList.add(Integer.valueOf(str1));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
