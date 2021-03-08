package period_3;

public class Point implements Shape {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double distance(Shape shape) {
        if (shape instanceof Point) {
            Point point = (Point) shape;
            return distance(point);
        }

        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return distance(circle);
        }

        return 0;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
    }

    public double distance(Circle circle) {
        double d = distance(circle.getCenter()) - circle.getRadius();
        return d > 0 ? d : 0;
    }

    @Override
    public void move(Vector vector) {
        x += vector.getX();
        y += vector.getY();
    }

    @Override
    public void rotate(double deg) {}

    @Override
    public void zoom(double ratio) {}

    @Override
    public String toString() {
        return String.format("Điểm (%.1f, %.1f)", x, y);
    }
}
