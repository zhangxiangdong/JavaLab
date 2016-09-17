package me.zhang.templatemethod;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Zhang on 11/19/2015 8:52 下午.
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "I rule!";
        g.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        new MyFrame("Template Method Pattern");
    }

}
