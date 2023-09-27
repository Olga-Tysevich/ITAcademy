package inProgress.lesson13;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {
    public void writeFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 1000; i++) {
                Random random = new Random();
                fileWriter.write(random.nextInt(100001) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mergeAndSortFileData(File firstFile, File secondFile, String outputFilePath) {
        File out = new File(outputFilePath);
        ArrayList<Integer> arrayList = setValuesOfArrayList(new ArrayList<>(), firstFile);
        setValuesOfArrayList(arrayList, secondFile);
        Collections.sort(arrayList);
        try (FileWriter fileWriter3 = new FileWriter(out)) {
            while (arrayList.iterator().hasNext()) {
                fileWriter3.write(arrayList.iterator().next() + "\n");
                arrayList.remove(arrayList.iterator().next());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<Integer> setValuesOfArrayList(ArrayList<Integer> arrayList, File file) {
        String str1;
        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file.getPath()))) {
            while ((str1 = bufferedReader1.readLine()) != null) {
                arrayList.add(Integer.valueOf(str1));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
