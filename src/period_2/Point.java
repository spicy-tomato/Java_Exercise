package period_2;

public abstract class Point {

    public abstract double distance(Point p);

    @Override
    public abstract boolean equals(Object obj);

    public abstract Point getSymmetry();

    @Override
    public abstract String toString();
}
