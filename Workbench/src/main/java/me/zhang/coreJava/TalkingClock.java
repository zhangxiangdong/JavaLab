package me.zhang.coreJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Zhang on 2017/10/17 11:28.
 */
public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        // ActionListener listener = new TimePrinter(this); // parameter automatically added
        ActionListener listener = this.new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public void start1(int interval, boolean beep) { /* implicit final on Java 8,
                                                        Only an effectively final variable can be used */
        // local class has no access modifier
        class TimePrinter implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("(Local class)At the tone, the time is " + new Date());
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public void start2() {
        Timer timer = new Timer(interval, e -> { // lambda expression
            System.out.println("(Anonymous inner class)At the tone, the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        timer.start();
    }

    public class TimePrinter implements ActionListener {

        // private TalkingClock outer;

        // public TimePrinter(TalkingClock clock) { // automatically generated code
        // outer = clock;
        //}

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("(Inner class)At the tone, the time is " + new Date());
            if (TalkingClock.this.beep) { // outer.beep
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
