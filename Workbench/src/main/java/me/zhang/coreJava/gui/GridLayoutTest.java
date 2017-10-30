package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhangxiangdong on 2017/10/30.
 */
public class GridLayoutTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setPreferredSize(new Dimension(300, 200));

            JButton display = new JButton("0");
            display.setEnabled(false);
            frame.add(display, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 4));

            addButton("7", panel);
            addButton("8", panel);
            addButton("9", panel);
            addButton("/", panel);

            addButton("4", panel);
            addButton("5", panel);
            addButton("6", panel);
            addButton("*", panel);

            addButton("1", panel);
            addButton("2", panel);
            addButton("3", panel);
            addButton("-", panel);

            addButton("0", panel);
            addButton(".", panel);
            addButton("=", panel);
            addButton("+", panel);

            frame.add(panel, BorderLayout.CENTER);
            frame.pack();

            frame.setResizable(false);
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private static void addButton(String s, JPanel panel) {
        panel.add(new JButton(s));
    }

}
