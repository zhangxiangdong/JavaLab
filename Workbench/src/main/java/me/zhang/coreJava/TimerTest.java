package me.zhang.coreJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Zhang on 2017/10/17 10:57.
 */
public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(10 * 1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    static class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
