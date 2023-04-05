package observer;

public class Plot implements Observer {
    private Action observed;

    Plot(Action action) {
        this.observed = action;
    }

    void printCurve() {
        Iterable<Double> values = observed.getValues();
        System.out.println(values);
    }

    @Override
    public void updateObserver() {
        this.printCurve();
    }
}
