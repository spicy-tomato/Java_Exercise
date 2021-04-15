package period_7__Working_with_files.E3;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromString(String string){
        String[] str = string.split(",");
        double x = Double.parseDouble(str[0]);
        double y = Double.parseDouble(str[1]);

        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}
