package period_3;

public class Rectangle implements Shape {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        return 0;
    }

    @Override
    public void move(Vector vector) {
        x += vector.getX();
        y += vector.getY();
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
        return String.format("Hình chữ nhật (%.1f, %.1f, %.1f, %.1f)", x, y, width, height);
    }
}
