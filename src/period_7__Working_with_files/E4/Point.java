package period_7__Working_with_files.E4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromString(String string) {

        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?,-?\\d+(\\.\\d+)?");
        Matcher m = p.matcher(string);

        String results = "";

        while (m.find()) {
            if (m.group(0) != null) {
                results = m.group(0);
            }
            else {
                results = m.group();
            }
        }

        String[] str = results.split(",");

        double x = Double.parseDouble(str[0]);
        double y = Double.parseDouble(str[1]);

        return new Point(x, y);
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}
