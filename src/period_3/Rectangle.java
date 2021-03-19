package period_3;

public class Rectangle implements Shape {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private double width;
    private double height;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public double perimeter() {
        return 2*width*height;
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

        if (shape instanceof Line) {
            Line line = (Line) shape;
            return line.distance(this);
        }

        if (shape instanceof LineSegment) {
            LineSegment lineSegment = (LineSegment) shape;
            return distance(lineSegment);
        }

        return 0;
    }

    @Override
    public void move(Vector vector) {
        p1.move(vector);
        p2.move(vector);
        p3.move(vector);
        p4.move(vector);
    }

    @Override
    public void rotate(double deg) {
        System.out.println("Rotated rectangle " + this + " by " + deg + " degree(s)");
    }

    @Override
    public void zoom(double ratio) {
        width *= ratio;
        height *= ratio;
    }

    @Override
    public String toString() {
        return String.format("Hình chữ nhật (%s, %s, %s, %s)", p1, p1, p3, p4);
    }
}
