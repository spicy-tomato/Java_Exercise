package period_7__Working_with_files.Bai1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String filePath = "D:/Projects/Java/Exercise/src/period_7__Working_with_files/Bai1/example.txt";

    private static final File file = new File(filePath);
    private static final Scanner inputScanner = new Scanner(System.in);
    private static Scanner fileScanner;

    public static void main(String[] args) throws FileNotFoundException {
        fileScanner = new Scanner(file);

        try {
            printFileContent();
            writeFile();
            printFileSize();
            printPath();
            printFileName();
        } catch (IOException ignored) { }

        changePermission();

        fileScanner.close();
        inputScanner.close();
    }

    private static void printFileContent() {
        System.out.println();
        System.out.println("File content:");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
    }

    private static void writeFile() throws IOException {
        System.out.println();
        System.out.print("Enter content that you want to append file: ");
        String str = inputScanner.nextLine();

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("\n" + str);

        fileWriter.close();
    }

    private static void printFileSize() {
        System.out.println();
        System.out.printf("Size of file: %d byte(s)", file.length());
    }

    private static void printPath() {
        System.out.println();
        System.out.printf("Path of file: %s", file.getPath());
    }

    private static void printFileName() {
        System.out.println();
        System.out.printf("File name: %s", file.getName());
    }

    private static void changePermission() {
        System.out.println();

        if (file.canWrite()) {
            file.setWritable(false);
            System.out.println("Change file permission to read only");
        }
        else {
            file.setWritable(true);
            System.out.println("Change file permission to write and read");
        }
    }
}
