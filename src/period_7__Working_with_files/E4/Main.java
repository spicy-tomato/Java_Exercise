package period_7__Working_with_files.E4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String pathSrc = "D:/Projects/Java/Exercise/src/period_7__Working_with_files/E4/datasrc.txt";
    private static final File fileSrc = new File(pathSrc);

    private static final String path = "D:/Projects/Java/Exercise/src/period_7__Working_with_files/E4/data.txt";
    private static final File file = new File(path);

    private static Scanner fileScanner;
    private static final List<Point> pointsArray = new ArrayList<>();

    public static void main(String[] args) {
        try {
            fileScanner = new Scanner(fileSrc);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp data!");
            return;
        }

        readData();
        writeData();

        fileScanner.close();
    }

    private static void readData() {
        String str = fileScanner.nextLine().trim();
        Pattern p = Pattern.compile("Point\\((-?\\d)+(\\.(\\d)+)?,(-?\\d)+(\\.(\\d)+)?\\)");
        Matcher m = p.matcher(str);

        List<String> results = new ArrayList<>();

        while (m.find()){
            if (m.group(0) != null){
                results.add(m.group(0));
            }
            else {
                results.add(m.group());
            }
        }

        for (var s : results) {
            pointsArray.add(Point.fromString(s));
        }
    }

    private static double sumDistance() {
        int n = pointsArray.size();
        double sum = 0;

        for (int i = 1; i < n; i++) {
            sum += pointsArray.get(i).distance(pointsArray.get(i - 1));
        }

        return sum;
    }

    private static void writeData() {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("Không thể mở tệp data!");
            return;
        }

        try {
            fileWriter.write("Number of points: " + pointsArray.size());
            fileWriter.write("\nTotal distance: " + sumDistance());
        } catch (IOException e) {
            System.out.println("Không thể ghi tệp data!");
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Không thể lưu tệp data!");
        }
    }
}
