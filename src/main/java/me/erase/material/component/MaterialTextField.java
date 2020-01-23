package me.erase.material.component;

import me.erase.material.FlatColor;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MaterialTextField extends JTextField {
    public MaterialTextField(String string) {
        setText(string);
        setForeground(FlatColor.DARK_PRESSED);
        setColumns(10);
        setBackground(FlatColor.DARKEST);
        setFont(new Font("Arial", Font.ITALIC, 17));
        setBorder(new LineBorder(FlatColor.RED));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setBorder(new LineBorder(FlatColor.GOLD_PRESSED));
                setFocusable(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBorder(new LineBorder(FlatColor.GOLD));
                setFocusable(true);
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                setBorder(new LineBorder(FlatColor.GOLD));
                setFocusable(true);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                if (getText().isEmpty()) {
                    setText(string);
                }
                setBorder(new LineBorder(FlatColor.RED));
            }
        });
    }
}
