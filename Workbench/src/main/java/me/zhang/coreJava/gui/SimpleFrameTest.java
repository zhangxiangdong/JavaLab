package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_HEIGHT;
import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_WIDTH;

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

class SimpleFrame extends JFrame {

    public SimpleFrame() throws HeadlessException {
        /* get screen dimension */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // frame.setUndecorated(true);
        // frame.setLocation(100, 100);
        // frame.setBounds(100, 100, 300, 200);
        setSize(width / 2, height / 2);
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setLocationByPlatform(true);

        String filePath = System.getProperty("user.dir") + "/Workbench/src/main/java/me/zhang/coreJava/gui/frame.png";
        Image image = Toolkit.getDefaultToolkit().getImage(filePath);
        ImageIcon imageIcon = new ImageIcon(image);
        // setIconImage(image);
        setIconImage(imageIcon.getImage());
        setTitle("Simple Frame");
        setResizable(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

/**
 * A custom component that displaya a text string.
 */
class MyComponent extends JComponent {

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