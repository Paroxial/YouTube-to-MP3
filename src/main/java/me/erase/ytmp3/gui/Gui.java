package me.erase.ytmp3.gui;

import me.erase.ytmp3.Main;

import java.awt.Component;
import java.awt.Font;


public class Gui {
    private final Components components = Main.getComponents();

    public Gui() {
        setupFrame();
        setupPanels();
        setupButtons();
        setupTextFields();
    }

    private void setupFrame() {
        components.materialFrame.setContentPane(components.contentPane);
    }

    private void setupPanels() {
        components.contentPane.setDarker();
        components.contentPane.setBounds(components.materialFrame.getBounds());
        components.contentPane.add(new Component[]{components.materialButton, components.materialTextField, components.materialButton2, components.materialButton3});
    }

    private void setupButtons() {
        components.materialButton.setRaisedRed();
        components.materialButton.setLocation(90, 80);
        components.materialButton.setText("Convert");

        components.materialButton2.setText("Your converted file will appear on the desktop.");
        components.materialButton2.setFlatInfo();
        components.materialButton2.setLocation(90, 150);

        components.materialButton3.setFlatWarning();
        components.materialButton3.setLocation(90, 210);
        components.materialButton3.setText("Developed by EraseUrFace and Paroxial");
        components.materialButton3.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void setupTextFields() {
        components.materialTextField.setSize(components.materialButton.getSize());
        components.materialTextField.setLocation(90, 20);
        components.materialFrame.setVisible(true);
    }
}
