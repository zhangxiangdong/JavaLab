package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_HEIGHT;
import static me.zhang.coreJava.gui.SimpleFrameTest.DEFAULT_WIDTH;

/**
 * Created by Zhang on 2017/10/21 21:30.
 */
public class SimpleFrame extends JFrame {

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
