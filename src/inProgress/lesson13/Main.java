package inProgress.lesson13;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //task #1
        File in1 = new File("src/inProgress/lesson13/in1.txt");
        File in2 = new File("src/inProgress/lesson13/in2.txt");
        FileManager fileManager = new FileManager();
        fileManager.writeFile(in1);
        fileManager.writeFile(in2);

        fileManager.mergeAndSortFileData(in1,in2,"src/inProgress/lesson13/out.txt");
    }
}


