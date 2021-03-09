package period_2;

public class Point2D extends Point {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double distance(Point p) {
        Point2D p2d = (Point2D) p;
        return Math.sqrt(Math.pow(x - p2d.getX(), 2) + Math.pow(x - p2d.getY(), 2));
    }

    @Override
    public Point2D getSymmetry() {
        return new Point2D(-x, -y);
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Point2D) {
            Point2D p2d = (Point2D) p;
            return x == p2d.getX() && y == p2d.getY();
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", x, y);
    }
}
