package adapter;

public class Main {
    public static void main(String[] args) {
        IDistance distanceAdapter = new FeetAdapter(new Foot(1000));
        System.out.println("Distance in meters (adapted from feet): " + distanceAdapter.getDistance());
    }
}