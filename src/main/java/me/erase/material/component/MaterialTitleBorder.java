package me.erase.material.component;

import me.erase.material.FlatColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MaterialTitleBorder extends JPanel {
    public MaterialTitleBorder() {
        setLocation(0, 0);
        setLayout(null);
    }

    public MaterialTitleBorder setBlue() {
        setBackground(FlatColor.BLUE);
        return this;
    }

    public MaterialTitleBorder setRed() {
        setBackground(FlatColor.RED);
        return this;
    }

    public MaterialTitleBorder setDark() {
        setBackground(FlatColor.DARK);
        return this;
    }

    public MaterialTitleBorder addCaption(String string) {
        JLabel label = new JLabel(string);

        label.setBounds(getBounds());
        label.setForeground(FlatColor.WHITE_TEXT);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);
        return this;
    }
}
