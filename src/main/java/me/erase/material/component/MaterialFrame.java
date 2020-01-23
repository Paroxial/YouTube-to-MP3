package me.erase.material.component;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MaterialFrame extends JFrame {
    private int positionX, positionY;

    public MaterialFrame(int x, int y) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(x, y);
        setLayout(null);
        setTitle("YouTube MP3 Converter");
        setResizable(false);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                positionX = event.getX();
                positionY = event.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                setLocation(event.getXOnScreen() - positionX, event.getYOnScreen() - positionY);
            }
        });

        try {
            setIconImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("youtube.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}