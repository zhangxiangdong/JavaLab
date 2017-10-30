package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhangxiangdong on 2017/10/30.
 */
public class BorderLayoutTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setPreferredSize(new Dimension(300, 200));

            JPanel panel = new JPanel();
            panel.add(new JButton("Alpha"));
            panel.add(new JButton("Beta"));
            panel.add(new JButton("Gamma"));

            JTextArea area = new JTextArea("Hello, world!");

            // BorderLayout is the default layout of JFrame
            frame.add(panel, BorderLayout.SOUTH);
            frame.add(area, BorderLayout.CENTER);
            frame.pack();

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
    }

}
