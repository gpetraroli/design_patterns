package mvc.view;

import mvc.controller.TemperatureController;
import mvc.model.TemperatureModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class TemperatureView extends JFrame implements Observer {
    private TemperatureModel temperatureModel;
    private TemperatureController temperatureController;

    // GUI components
    private JButton plus;
    private JButton minus;
    private JTextField value;
    private JSlider slider;

    public TemperatureView(TemperatureModel model, TemperatureController controller) {
        super("MVC");

        this.temperatureModel = model;
        this.temperatureController = controller;

        temperatureModel.addObserver(this);

        this.setupGraphics();

        // listeners
        plus.addActionListener((ActionEvent e) -> temperatureController.increment());
        minus.addActionListener((ActionEvent e) -> temperatureController.decrement());
        slider.addChangeListener((ChangeEvent e) -> temperatureController.setByInt(slider.getValue()));
        value.addActionListener((ActionEvent e) -> temperatureController.setByString(value.getText()));

        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.value.setText(Integer.toString(temperatureModel.getValue()));
        this.slider.setValue(temperatureModel.getValue());
        this.repaint();
    }

    void setupGraphics() {
        this.plus = new JButton("+");
        this.minus = new JButton("-");
        this.value = new JTextField(Integer.toString(temperatureModel.DEFAULT_TEMPERATURE));
        this.slider = new JSlider(JSlider.HORIZONTAL, temperatureModel.MIN_TEMPERATURE, temperatureModel.MAX_TEMPERATURE, 0);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 5);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        contentPane.add(plus, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(minus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        contentPane.add(value, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(slider, gbc);

        this.setMinimumSize(new Dimension(640, 400));
        plus.setFont(new Font("Arial", Font.BOLD, 20));
        minus.setFont(new Font("Arial", Font.BOLD, 20));
        value.setFont(new Font("Arial", Font.BOLD, 20));
        slider.setFont(new Font("Arial", Font.BOLD, 20));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}