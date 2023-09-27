package inProgress.lesson13;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //task #1
        File in1 = new File("src/inProgress/lesson13/in1.txt");
        File in2 = new File("src/inProgress/lesson13/in2.txt");
        try (FileWriter fileWriter1 = new FileWriter(in1);
             FileWriter fileWriter2 = new FileWriter(in2)) {
            for (int i = 0; i < 1000; i++) {
                Random random = new Random();
                fileWriter1.write(random.nextInt(100000) + "\n");
                fileWriter2.write(random.nextInt(100000) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(in1));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(in2))){
            String str1;
            String str2;
            ArrayList<Integer> strings = new ArrayList<>();
            File out = new File("src/inProgress/lesson13/out.txt");
            while ((str1 = bufferedReader1.readLine()) != null && (str2 = bufferedReader2.readLine()) != null) {
                strings.add(Integer.valueOf(str1));
                strings.add(Integer.valueOf(str2));
            }

            Collections.sort(strings);
            try (FileWriter fileWriter3 = new FileWriter(out)) {
                while (strings.iterator().hasNext()) {
                    fileWriter3.write(strings.iterator().next() + "\n");
                    strings.remove(strings.iterator().next());
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


