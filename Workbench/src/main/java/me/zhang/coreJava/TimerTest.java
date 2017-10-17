package me.zhang.coreJava;

import javax.swing.*;

/**
 * Created by Zhang on 2017/10/17 10:57.
 */
public class TimerTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10 * 1000, false);
        // clock.start();
        TalkingClock.TimePrinter printer = clock.new TimePrinter();

        Timer timer = new Timer(10 * 1000, printer);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}
