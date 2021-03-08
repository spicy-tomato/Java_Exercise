package period_3;

public interface Shape {

    double area();

    double perimeter();

    double distance(Shape shape);

    void move(Vector vector);

    void rotate(double deg);

    void zoom(double ratio);
}
