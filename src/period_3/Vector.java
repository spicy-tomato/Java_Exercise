package period_3;

public class Vector {

    private final double x;
    private final double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector normal(){
        if(x <= 0 && y >= 0){
            return new Vector(y, -x);
        }

        return new Vector(-y, x);
    }


    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", x, y);
    }
}
