package me.zhang.templatemethod;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Zhang on 11/19/2015 9:00 下午.
 */
public class MyApplet extends Applet {

    String message;

    @Override
    public void init() {
        message = "Hello, I'm alive!";
        repaint();
    }

    @Override
    public void start() {
        message = "Now I'm starting up...";
        repaint();
    }

    @Override
    public void stop() {
        message = "Oh, new I'm being stopped...";
        repaint();
    }

    @Override
    public void destroy() {
        // Applet is being destroied
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(message, 5, 15);
    }
}
