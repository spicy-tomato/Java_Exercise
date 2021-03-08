package period_3;

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
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double distance(Shape shape) {
        return 0;
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
