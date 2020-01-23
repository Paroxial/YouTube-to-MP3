package me.erase.material.component;

import me.erase.material.FlatColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MaterialButton extends JLabel {
    public MaterialButton(int x, int y) {
        setSize(x, y);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public MaterialButton setRaisedBlue() {
        setBorder(new LineBorder(getParent().getBackground(), 2));
        setOpaque(true);
        setBackground(FlatColor.BLUE);
        setForeground(FlatColor.WHITE_TEXT);
        setFont(new Font("Arial", Font.PLAIN, 20));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setBorder(new LineBorder(FlatColor.RED_PRESSED, 2));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setBorder(new LineBorder(getParent().getBackground(), 2));
            }
        });
        return this;
    }

    public MaterialButton setRaisedRed() {
        setBorder(new LineBorder(getParent().getBackground(), 2));
        setOpaque(true);
        setBackground(FlatColor.RED);
        setForeground(FlatColor.WHITE_TEXT);
        setFont(new Font("Arial", Font.PLAIN, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setBackground(FlatColor.RED_PRESSED);
                System.out.println(Thread.currentThread().getName());
                setBorder(new LineBorder(getParent().getBackground(), 3));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(FlatColor.RED_HOVERED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(FlatColor.RED);
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setBackground(FlatColor.RED);
                setBorder(new LineBorder(FlatColor.RED, 3));
            }
        });
        return this;
    }

    public MaterialButton setRaisedDark() {
        setBorder(new LineBorder(getParent().getBackground(), 2));
        setOpaque(true);
        setBackground(FlatColor.DARK_HOVERED);
        setForeground(FlatColor.WHITE_TEXT);
        setFont(new Font("Arial", Font.PLAIN, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setBorder(new LineBorder(getParent().getBackground(), 2));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setBorder(new LineBorder(getParent().getBackground(), 2));
            }
        });
        return this;
    }

    public MaterialButton setRaisedWhite() {
        setBorder(new LineBorder(getParent().getBackground(), 2));
        setOpaque(true);
        setBackground(FlatColor.WHITE_HOVERED);
        setForeground(FlatColor.GRAY_TEXT);
        setFont(new Font("Arial", Font.PLAIN, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setBorder(new LineBorder(getParent().getBackground(), 2));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setBorder(new LineBorder(getParent().getBackground(), 2));
            }
        });
        return this;
    }

    public MaterialButton setFlatInfo() {
        setForeground(new Color(144, 144, 144));
        setFont(new Font("Arial", Font.PLAIN, 15));
        setBorder(null);
        setBackground(new Color(45, 45, 45));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setOpaque(true);
                repaint();                System.out.println(Thread.currentThread().getName());
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setOpaque(false);
                repaint();
            }
        });
        return this;
    }

    public MaterialButton setFlatWarning() {
        setForeground(FlatColor.RED);
        setFont(new Font("Arial", Font.BOLD, 15));
        setBorder(null);
        setBackground(new Color(45, 45, 45));
/*
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                setOpaque(true);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setOpaque(false);
                repaint();
            }
        });*/
        return this;
    }
}
