package inProgress.lesson13;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {
    Random random;

    public void writeNumbersToFile(String outFilePath) {
        try (FileWriter fileWriter = new FileWriter(outFilePath)) {
            for (int i = 0; i < 1000; i++) {
                random = new Random();
                fileWriter.write(random.nextInt(100001) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mergeAndSortFileData(String pathFirstFile, String pathSecondFile, String outFilePath) {
        ArrayList<Integer> arrayList = copyFileDataToArrayList(new ArrayList<>(), pathFirstFile);
        copyFileDataToArrayList(arrayList, pathSecondFile);
        Collections.sort(arrayList);
        try (FileWriter fileWriter = new FileWriter(outFilePath)) {
            while (arrayList.iterator().hasNext()) {
                fileWriter.write(arrayList.iterator().next() + "\n");
                arrayList.remove(arrayList.iterator().next());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeBinaryFile(String outFilePath) {
        try (OutputStream outputStream = new FileOutputStream(outFilePath)) {
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
            int current;
            double sum = 0;
            while ((current = inputStream.read()) != -1) {
                System.out.print(current + " ");
                sum += current;
            }
            System.out.println("\n" + (sum / 30));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<Integer> copyFileDataToArrayList(ArrayList<Integer> arrayList, String filePath) {
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
