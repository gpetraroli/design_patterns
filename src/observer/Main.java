package observer;

public class Main {
    public static void main(String[] args) {
        Action google = new Action();
        Plot googleCurve = new Plot(google);

        google.addObserver(googleCurve);

        google.addValue(20.10);
        google.addValue(21.0);
    }
}