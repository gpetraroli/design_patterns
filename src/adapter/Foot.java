package adapter;

public class Foot implements IFeet {
    private final double feet;

    public Foot(double feet) {
        this.feet = feet;
    }

    @Override
    public double getFeet() {
        return feet;
    }
}
