package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * Created by Zhang on 2017/10/22 21:23.
 */
public class ButtonFrame extends JFrame {

    private JPanel buttonPanel;

    public ButtonFrame() throws HeadlessException {
        setPreferredSize(new Dimension(300, 200));

        buttonPanel = new JPanel();

        addButton("Red", Color.RED);
        addButton("Green", Color.GREEN);
        addButton("Blue", Color.BLUE);

        /* perform a method invocation action */
        JButton loadButton = new JButton("Load");
        // both target and action must be public
        loadButton.addActionListener(EventHandler.create(ActionListener.class, this, "load"));
        buttonPanel.add(loadButton);

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

    /**
     * Invoked on button click
     */
    public void load() {
        System.out.println("Loading...");
    }

}
