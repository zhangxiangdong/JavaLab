package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_HEIGHT;
import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_WIDTH;

/**
 * A custom component that displaya a text string.
 */
public class MyComponent extends JComponent {

    public static final int TEXT_Y = 100;
    public static final int TEXT_X = 75;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");

        g.drawString("Hello, World!", TEXT_X, TEXT_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
