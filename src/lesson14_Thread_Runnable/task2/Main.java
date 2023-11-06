package lesson14_Thread_Runnable.task2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src\\" + SaveAsThread.class.getPackageName().replace(".", "\\") + "\\Array_file.txt";
        File file = new File(path);
        SaveAsThread first = new SaveAsThread(100, file);
        first.setName("first thread");
        SaveAsThread second = new SaveAsThread(150, file);
        second.setName("second thread");
        SaveAsThread third = new SaveAsThread(200, file);
        third.setName("third thread");

        first.start();
        second.start();
        third.start();

    }
}
