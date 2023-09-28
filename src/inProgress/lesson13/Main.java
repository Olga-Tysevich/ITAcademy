package inProgress.lesson13;

public class Main {
    public static void main(String[] args) {
        //task #1
        FileManager fileManager = new FileManager();
        fileManager.writeNumbersToFile("src/inProgress/lesson13/in1.txt");
        fileManager.writeNumbersToFile("src/inProgress/lesson13/in2.txt");
        fileManager.mergeAndSortFileData("src/inProgress/lesson13/in1.txt", "src/inProgress/lesson13/in2.txt",
                "src/inProgress/lesson13/out.txt");

        //task #2
        fileManager.writeBinaryFile("src/inProgress/lesson13/binaryFile.txt");
        fileManager.readBinaryFile("src/inProgress/lesson13/binaryFile.txt");
    }
}


