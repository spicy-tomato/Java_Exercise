package period_3;

import java.util.List;

public class Line implements Shape {

    //  ax + by + c = 0
    private double a;
    private double b;
    private double c;
    private Vector normalVector;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        normalVector = new Vector(a, b);
    }

    public Line(Point p1, Point p2) {
        Vector v = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY());
        normalVector = v.normal();
        a = normalVector.getX();
        b = normalVector.getY();
        c = a*p1.getX() + b*p1.getY();
    }

    @Override
    public double area() { return 0; }

    @Override
    public double perimeter() { return 0; }

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
            return distance(line);
        }

        if (shape instanceof LineSegment){
            LineSegment lineSegment = (LineSegment) shape;
            return distance(lineSegment);
        }

        return 0;
    }

    public double distance(Point point) {
        //  d = |a*x0 + b*y0 + c| / sqrt(a^2 + b^2)
        return Math.abs(a*point.getX() + b*point.getY() + c)/Math.sqrt(a*a + b*b);
    }

    public double distance(Circle circle) {
        double distanceToCenter = distance(circle.getCenter());
        double distance = distanceToCenter - circle.getRadius();

        return distance > 0 ? distance : 0;
    }

    public double distance(Line line) {
        //  d = |c1 - c2| / sqrt(a^2 + b^2)
        if (a == line.a && b == line.b && c != line.c) {
            return Math.abs(c - line.c)/Math.sqrt(a*a + b*b);
        }

        return 0;
    }

    public double distance(LineSegment lineSegment){
        if (a == lineSegment.getLine().a && b == lineSegment.getLine().b && c != lineSegment.getLine().c)
            return Math.abs(c - lineSegment.getLine().c)/Math.sqrt(a*a + b*b);{
        }

        List<Point> points = lineSegment.getPoints();

        return distanceFromLineToLineSegment(points.get(0), points.get(1));
    }

    private double distanceFromLineToLineSegment(Point a, Point b){
        Point midpoint = new LineSegment(a, b).midPoint();

        if (a.distance(b) < 1e-5) {
            return distance(midpoint);
        }

        double d1 = distance(a);
        double d2 = distance(b);

        if (d1 < d2) {
            return distanceFromLineToLineSegment(a, midpoint);
        }

        return distanceFromLineToLineSegment(midpoint, b);
    }

    @Override
    public void move(Vector vector) {
        System.out.println("Translated line " + this + " by vector " + vector);
    }

    @Override
    public void rotate(double deg) {
        System.out.println("Rotated line " + this + " by " + deg + " degree(s)");
    }

    @Override
    public void zoom(double ratio) {}

    @Override
    public String toString() {
        return String.format("Đường thẳng: %.1fx + %.1fy + %.1f", a, b, c);
    }
}
