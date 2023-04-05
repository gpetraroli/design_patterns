package observer;

import java.util.LinkedList;


public class Action implements Observable {

    private LinkedList<Observer> observers = new LinkedList<>();
    private LinkedList<Double> values = new LinkedList<>();


    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : this.observers) {
            observer.updateObserver();
        }
    }

    void addValue(double value) {
        this.values.add(value);
        this.notifyObservers();
    }

    Iterable<Double> getValues() {
        return this.values;
    }
}
