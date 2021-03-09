package period_2;

public abstract class Point {

    public abstract double distance(Point p);

    public abstract Point getSymmetry();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
