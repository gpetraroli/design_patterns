package mvc;

import mvc.controller.TemperatureController;
import mvc.model.TemperatureModel;
import mvc.view.TemperatureView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureModel temperatureModel = new TemperatureModel();
            TemperatureController temperatureController = new TemperatureController(temperatureModel);
            new TemperatureView(temperatureModel, temperatureController);
        });
    }
}
