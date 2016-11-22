package me.zhang.combined;

import javax.swing.*;

/**
 * Created by Li on 3/6/2016 10:45 AM.
 */
public class BeatBar extends JProgressBar implements Runnable {

    Thread thread;

    public BeatBar() {
        thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            int value = getValue();
            value = (int) (value * .75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ignored) {
            }
        }
    }
}
