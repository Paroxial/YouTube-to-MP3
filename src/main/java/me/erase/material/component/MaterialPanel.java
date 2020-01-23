package me.erase.material.component;

import me.erase.material.FlatColor;

import javax.swing.JPanel;
import java.awt.Component;

public class MaterialPanel extends JPanel {
    public MaterialPanel() {
        setLayout(null);
    }

    public MaterialPanel add(Component[] components) {
        for (Component component : components) {
            add(component);
        }
        return this;
    }

    public MaterialPanel setBlue() {
        setBackground(FlatColor.BLUE);
        return this;
    }

    public MaterialPanel setRed() {
        setBackground(FlatColor.RED);
        return this;
    }

    public MaterialPanel setDark() {
        setBackground(FlatColor.DARK);
        return this;
    }

    public MaterialPanel setDarker() {
        setBackground(FlatColor.DARKER);
        return this;
    }
}
