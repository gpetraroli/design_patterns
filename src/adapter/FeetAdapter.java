package adapter;

// adapter
public class FeetAdapter implements IDistance {
    private final IFeet feet;

    public FeetAdapter(IFeet feet) {
        this.feet = feet;
    }

    @Override
    public double getDistance() {
        return feet.getFeet() * 0.3048;
    }
}
