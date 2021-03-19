package period_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineSegment implements Shape {

    private Line line;
    private Point p1;
    private Point p2;

    public LineSegment(Point p1, Point p2) {
        this.line = new Line(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line getLine() {
        return line;
    }

    public List<Point> getPoints() {
        List<Point> points = new ArrayList<Point>();
        points.add(p1);
        points.add(p2);

        return points;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void setPoints(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
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
            return line.distance(this);
        }

        if (shape instanceof LineSegment) {
            LineSegment lineSegment = (LineSegment) shape;
            return distance(lineSegment);
        }

        return 0;
    }

    public double distance(Point point) {
        return distanceFromLineSegmentToPoint(point, p1, p2);
    }

    public double distance(Circle circle) {
        double distanceToCircleCenter = distanceFromLineSegmentToPoint(circle.getCenter(), p1, p2);
        double d = distanceToCircleCenter - circle.getRadius();

        return d > 0 ? d : 0;
    }

    public double distance(LineSegment lineSegment) {
        List<Point> points = lineSegment.getPoints();
        List<Double> d = new ArrayList<>();

        d.add(distance(points.get(0)));
        d.add(distance(points.get(1)));
        d.add(lineSegment.distance(p1));
        d.add(lineSegment.distance(p2));

        return Collections.min(d);
    }

    private double distanceFromLineSegmentToPoint(Point point, Point a, Point b) {
        Point midpoint = new LineSegment(a, b).midPoint();

        if (a.distance(b) < 1e-5) {
            return point.distance(midpoint);
        }

        double d1 = point.distance(a);
        double d2 = point.distance(b);

        if (d1 < d2) {
            return distanceFromLineSegmentToPoint(point, a, midpoint);
        }

        return distanceFromLineSegmentToPoint(point, midpoint, b);
    }

    @Override
    public void move(Vector vector) {}

    @Override
    public void rotate(double deg) {}

    @Override
    public void zoom(double ratio) {}

    public Point midPoint() {
        return new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2);
    }

    public double length(){
        return p1.distance(p2);
    }
}
