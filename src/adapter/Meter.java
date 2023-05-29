package adapter;

public class Meter implements IDistance {
    private final double distance;

    public Meter(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistance() {
        return distance;
    }
}
