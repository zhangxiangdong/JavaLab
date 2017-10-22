package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Zhang on 2017/10/22 20:21.
 */
public class EventTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(ButtonFrame::new);
    }

}

class ButtonFrame extends JFrame {

    private JPanel buttonPanel;

    public ButtonFrame() throws HeadlessException {
        setPreferredSize(new Dimension(300, 200));

        buttonPanel = new JPanel();

        addButton("Red", Color.RED);
        addButton("Green", Color.GREEN);
        addButton("Blue", Color.BLUE);

        add(buttonPanel);
        pack();

        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButton(String label, Color color) {
        JButton button = new JButton(label);
        button.addActionListener((e) -> buttonPanel.setBackground(color));
        buttonPanel.add(button);
    }

}
