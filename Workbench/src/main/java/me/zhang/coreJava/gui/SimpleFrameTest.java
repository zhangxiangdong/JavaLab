package me.zhang.coreJava.gui;

import java.awt.*;

/**
 * Created by Zhang on 2017/10/19 20:37.
 */
public class SimpleFrameTest {

    public static final int DEFAULT_HEIGHT = 200;
    public static final int DEFAULT_WIDTH = 300;

    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());

        EventQueue.invokeLater(() -> {
            // System.out.println(Thread.currentThread().getName());

            SimpleFrame frame = new SimpleFrame();

            Container container = frame.getContentPane();
            Component component = new MyComponent();
            container.add(component);
            /* could use JFrame.add() directly on Java SE 5.0 and above */
            // frame.add(text);

            // frame.show();
            frame.setVisible(true);
        });
    }

}