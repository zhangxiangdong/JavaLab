package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_HEIGHT;
import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_WIDTH;

/**
 * A custom component that displaya a text string.
 */
public class MyComponent extends JComponent {

    public static final int TEXT_Y = 50;
    public static final int TEXT_X = 50;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");

        Font font = new Font("SansSerif", Font.ITALIC, 14);
        AttributedString styledString = new AttributedString("你好，World!");
        styledString.addAttribute(TextAttribute.FONT, font);
        g.setColor(new Color(255, 0, 0));
        g.drawString(styledString.getIterator(), TEXT_X, TEXT_Y / 2);

        String fontFilePath = System.getProperty("user.dir") + "/Workbench/src/main/java/me/zhang/coreJava/gui/simkai.ttf";
        try {
            // load font from local
            g.setFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath)).deriveFont(15.0f));
            g.setColor(new Color(0, 255, 0));
            g.drawString("Hello, 世界！", TEXT_X, TEXT_Y);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

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
        Ellipse2D bigCircle = new Ellipse2D.Double();
        bigCircle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        Rectangle2D smallRect = new Rectangle2D.Double();
        smallRect.setFrameFromCenter(centerX, centerY, centerX + radius / 4, centerY + radius / 4);

        g2D.setPaint(Color.RED);
        g2D.draw(doubleRect);

        g2D.setPaint(Color.GREEN);
        g2D.draw(doubleLine);

        g2D.setPaint(Color.ORANGE);
        g2D.draw(floatEllipse);

        g2D.setPaint(Color.BLUE);
        g2D.draw(bigCircle);

        g2D.setPaint(Color.MAGENTA);
        g2D.fill(smallRect);

        String imageFilePath = System.getProperty("user.dir") + "/Workbench/src/main/java/me/zhang/coreJava/gui/frame.png";
        final int imageWidth = 64;
        final int imageHeight = 64;
        final int imageX = getWidth() - 256;
        int imageY = getHeight() - 256;
        g2D.drawImage(
                new ImageIcon(imageFilePath).getImage(),
                imageX, imageY,
                imageWidth, imageHeight,
                null
        );

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                g2D.copyArea(
                        imageX, imageY,
                        imageWidth, imageHeight,
                        i * (imageWidth + 10), j * (imageHeight + 10)
                );
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
