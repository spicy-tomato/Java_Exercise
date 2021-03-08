package period_2;

public class Point3D extends Point2D {

    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    //  @formatter:off
    @Override
    public double distance(Point p) {
        Point3D p3d = (Point3D) p;
        return Math.sqrt(
                Math.pow(getX() - p3d.getX(), 2) +
                Math.pow(getY() - p3d.getY(), 2) +
                Math.pow(z - p3d.getZ(), 2)
        );
    }
    //  @formatter:on

    @Override
    public boolean equals(Object p) {
        if (p instanceof Point3D){
            Point3D p3d = (Point3D) p;
            return getX() == p3d.getX() && getY() == p3d.getY() && z == p3d.getZ();
        }

        return false;
    }

    @Override
    public Point3D getSymmetry() {
        return new Point3D(-getX(), -getY(), -z);
    }

    @Override
    public String toString() {
        return String.format("(%.1f, %.1f, %.1f)", getX(), getY(), z);
    }
}
