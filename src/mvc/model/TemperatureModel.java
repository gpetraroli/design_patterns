package mvc.model;

import java.util.Observable;

public class TemperatureModel extends Observable {
    public final int MIN_TEMPERATURE = -273;
    public final int MAX_TEMPERATURE = 1000;

    private int value;

    public TemperatureModel() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        setChanged();
        notifyObservers();
    }
}