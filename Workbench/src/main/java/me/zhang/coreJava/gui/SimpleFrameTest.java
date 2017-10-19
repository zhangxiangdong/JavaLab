package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Zhang on 2017/10/19 20:37.
 */
public class SimpleFrameTest {

    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());

        EventQueue.invokeLater(() -> {
            // System.out.println(Thread.currentThread().getName());

            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // frame.setUndecorated(true);

            // frame.setLocation(100, 100);
            // frame.setBounds(100, 100, 300, 200);
            frame.setLocationByPlatform(true);

            try {
                URL iconLocation = new URL("https://cdn2.iconfinder.com/data/icons/circle-icons-1/64/focus-128.png");
                ImageIcon icon = new ImageIcon(iconLocation);
                frame.setIconImage(icon.getImage());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            frame.setTitle("Simple Frame");

            frame.setResizable(true);

            // frame.show();
            frame.setVisible(true);
        });
    }

}

class SimpleFrame extends JFrame {

    public static final int DEFAULT_HEIGHT = 200;
    public static final int DEFAULT_WIDTH = 300;

    public SimpleFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
