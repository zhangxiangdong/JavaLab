package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:13 PM.
 */
public class Radio implements ElectronicDevice {

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Radio is on.");
    }

    @Override
    public void off() {
        System.out.println("Radio is off.");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Radio volume is at " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Radio volume is at " + volume);
    }
}
