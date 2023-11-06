package lesson13_Files;

public class Main {
    public static void main(String[] args) {
        //task #1
        String packagePath = "src\\" + Main.class.getPackageName().replace(".", "\\");
        FileManager fileManager = new FileManager();
        fileManager.writePosNumbersToFile(packagePath + "\\in1.txt", 1000, 100000);
        fileManager.writePosNumbersToFile(packagePath + "\\in2.txt", 1000, 100000);
        fileManager.mergeAndSortFileData(packagePath + "\\in1.txt", packagePath + "\\in2.txt",
                packagePath + "\\out.txt");

        //task #2
        fileManager.writePosNumbersToBinaryFile(packagePath + "\\binaryFile.txt", 30, 100);
        fileManager.printNumbersFromBinaryFile(packagePath + "\\binaryFile.txt");
    }
}


