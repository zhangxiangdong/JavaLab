package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhangxiangdong on 2017/10/24.
 */
public class PlafTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(PlafFrame::new);
    }

}

class PlafFrame extends JFrame {

    private JPanel panel;

    public PlafFrame() throws HeadlessException {

        setPreferredSize(new Dimension(300, 200));
        panel = new JPanel();

        UIManager.LookAndFeelInfo[] feels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : feels) {
            // System.out.println(info.getName());
            addButton(info.getName(), info.getClassName());
        }

        add(panel);
        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * Make a button to change the pluggable look and feel.
     *
     * @param name      the button name
     * @param className the look and feel class name
     */
    private void addButton(String name, String className) {
        JButton button = new JButton(name);
        button.addActionListener((e) -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(panel);
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
            }
        });
        panel.add(button);
    }
}
