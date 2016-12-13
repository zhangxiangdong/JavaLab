package com.zhang.behavioral.command;

import java.util.List;

/**
 * Created by Zhang on 12/13/2016 10:15 PM.
 */
public class TurnItAllOff implements Command {

    List<ElectronicDevice> devices;

    public TurnItAllOff(List<ElectronicDevice> newDevices) {
        this.devices = newDevices;
    }

    @Override
    public void execute() {
        for (ElectronicDevice device : devices) {
            device.off();
        }
    }

    @Override
    public void undo() {
        for (ElectronicDevice device : devices) {
            device.on();
        }
    }
}
