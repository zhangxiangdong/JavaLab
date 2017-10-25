package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

        // define actions
        Action redAction = new ColorAction("Red", Color.RED);
        Action greenAction = new ColorAction("Green", Color.GREEN);
        Action blueAction = new ColorAction("Blue", Color.BLUE);

        // add buttons for these actions
        buttonPanel.add(new JButton(redAction));
        buttonPanel.add(new JButton(greenAction));
        buttonPanel.add(new JButton(blueAction));

        /* perform a method invocation action */
        JButton loadButton = new JButton("Load");
        // both target and action must be public
        loadButton.addActionListener(EventHandler.create(ActionListener.class, this, "load"));
        buttonPanel.add(loadButton);

        add(buttonPanel);
        pack();

        // associate the R, G, and B keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        imap.put(KeyStroke.getKeyStroke("ctrl G"), "panel.green");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");

        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.red", redAction);
        amap.put("panel.green", greenAction);
        amap.put("panel.blue", blueAction);

        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class ColorAction extends AbstractAction {

        public static final String KEY_COLOR = "color";

        /**
         * Constructs a color action.
         *
         * @param name the name to show on the button
         * @param c    the background color
         */
        public ColorAction(String name, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue(KEY_COLOR, c);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue(KEY_COLOR);
            buttonPanel.setBackground(c);
        }
    }

    /**
     * Invoked on button click
     */
    public void load() {
        System.out.println("Loading...");
    }

}
