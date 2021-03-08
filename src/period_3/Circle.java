package period_3;

public class Circle implements Shape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius > 0 ? radius : 1;
    }

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double distance(Shape shape) {
        if (shape instanceof Point) {
            Point point = (Point) shape;
            return point.distance(this);
        }

        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return distance(circle);
        }

        return 0;
    }

    public double distance(Circle circle) {
        double d = center.distance(circle.getCenter());
        double s = radius + circle.radius;

        return d > s ? d - s : 0;
    }

    @Override
    public void move(Vector vector) {
        double x = center.getX() + vector.getX();
        double y = center.getY() + vector.getY();

        center.setPoint(x, y);
    }

    @Override
    public void rotate(double deg) {}

    @Override
    public void zoom(double ratio) {
        radius *= ratio;
    }

    @Override
    public String toString() {
        return String.format("Đường tròn (x-%.1f)^2 + (y-%.1f)^2 = %.1f",
                center.getX(), center.getY(), radius*radius);
    }
}
