package inProgress.lesson13;

public class Main {
    public static void main(String[] args) {
        //task #1
        FileManager fileManager = new FileManager();
        fileManager.writeFile("src/inProgress/lesson13/in1.txt");
        fileManager.writeFile("src/inProgress/lesson13/in2.txt");
        fileManager.mergeAndSortFileData("src/inProgress/lesson13/in1.txt", "src/inProgress/lesson13/in2.txt",
                "src/inProgress/lesson13/out.txt");

        //task #2
        fileManager.createBinaryFile("src/inProgress/lesson13/binaryFile.txt");
        fileManager.readBinaryFile("src/inProgress/lesson13/binaryFile.txt");
    }
}

