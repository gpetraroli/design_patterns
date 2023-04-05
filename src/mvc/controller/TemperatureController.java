package mvc.controller;

import mvc.model.TemperatureModel;

public class TemperatureController {
    private final TemperatureModel temperatureModel;

    public TemperatureController(TemperatureModel t) {
        this.temperatureModel = t;
    }

    public void increment() {
        this.temperatureModel.setValue(this.temperatureModel.getValue() + 1);
    }

    public void decrement() {
        this.temperatureModel.setValue(this.temperatureModel.getValue() - 1);
    }

    public void setByInt(int n) {
        temperatureModel.setValue(n);
    }

    public boolean setByString(String s) {
        try {
            int value = Integer.parseInt(s);
            this.temperatureModel.setValue(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
