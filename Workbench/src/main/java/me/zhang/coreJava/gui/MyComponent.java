package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

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

        // g.drawString("Hello, World!", TEXT_X, TEXT_Y);
        Graphics2D g2D = (Graphics2D) g;

        double x = 100;
        double y = 100;
        double w = 200;
        double h = 150;
        Rectangle2D doubleRect = new Rectangle2D.Double(x, y, w, h);
        Line2D doubleLine = new Line2D.Double(x, y, x + w, y + h);

        Ellipse2D floatEllipse = new Ellipse2D.Float();
        // floatEllipse.setFrameFromDiagonal(x, y, x + w, y + h);
        floatEllipse.setFrame(doubleRect);

        double centerX = doubleRect.getCenterX();
        double centerY = doubleRect.getCenterY();
        double radius = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2)) / 2;
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);

        g2D.draw(doubleRect);
        g2D.draw(doubleLine);
        g2D.draw(floatEllipse);
        g2D.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
