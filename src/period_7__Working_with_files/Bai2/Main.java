package period_7__Working_with_files.Bai2;

import java.io.File;

public class Main {

    private static final String path = "D:/Rainmeter";
    private static final File directory = new File(path);
    private static int fileCount = 0;

    public static void main(String[] args) {
        printFiles(directory);
        System.out.println();
        System.out.println("Execute file: " + fileCount);
    }

    private static void printFiles(File directory) {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (var f : listFiles) {
                if (f.isFile()) {
                    String filePath = f.getPath();
                    String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);

                    try {
                        String fileExtension = fileName.substring(fileName.indexOf(".") + 1);
                        if (fileExtension.equals("exe")) {
                            System.out.printf("\tFound execute file: %s\n", filePath);
                            fileCount++;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }

                }
                else {
                    System.out.printf("Scanning %s\n", f.getPath());
                    printFiles(f);
                }
            }
        }
    }
}
