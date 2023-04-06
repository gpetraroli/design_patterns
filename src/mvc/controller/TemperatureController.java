package mvc.controller;

import mvc.model.TemperatureModel;

public class TemperatureController {
    private final TemperatureModel temperatureModel;

    public TemperatureController(TemperatureModel t) {
        this.temperatureModel = t;
    }

    public void increment() {
        if (temperatureModel.getValue() + 1 > temperatureModel.MAX_TEMPERATURE) {
            return;
        }
        this.temperatureModel.setValue(this.temperatureModel.getValue() + 1);
    }

    public void decrement() {
        if (temperatureModel.getValue() - 1 < temperatureModel.MIN_TEMPERATURE) {
            return;
        }
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
