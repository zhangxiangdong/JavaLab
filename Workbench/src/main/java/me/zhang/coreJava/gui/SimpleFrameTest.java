package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Zhang on 2017/10/19 20:37.
 */
public class SimpleFrameTest {

    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());

        EventQueue.invokeLater(() -> {
            // System.out.println(Thread.currentThread().getName());

            SimpleFrame frame = new SimpleFrame();
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
