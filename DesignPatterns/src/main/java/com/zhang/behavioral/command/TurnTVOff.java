package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:03 PM.
 */
public class TurnTVOff implements Command {

    ElectronicDevice device;

    public TurnTVOff(ElectronicDevice newDevice) {
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.off();
    }

    @Override
    public void undo() {
        device.on();
    }
}
