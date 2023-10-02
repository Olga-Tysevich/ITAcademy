package inProgress.lesson14.task2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src\\" + SaveAsThread.class.getPackageName().replace(".", "\\") + "\\Array_file.txt";
        File file = new File(path);
        SaveAsThread first = new SaveAsThread(10, file);
        first.setName("first thread");
        SaveAsThread second = new SaveAsThread(15, file);
        second.setName("second thread");
        SaveAsThread third = new SaveAsThread(20, file);
        third.setName("third thread");

        first.start();
        second.start();
        third.start();

    }
}
