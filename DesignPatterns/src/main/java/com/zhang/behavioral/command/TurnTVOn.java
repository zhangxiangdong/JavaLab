package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 9:58 PM.
 */
public class TurnTVOn implements Command {

    ElectronicDevice device;

    public TurnTVOn(ElectronicDevice newDevice) {
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.on();
    }

    @Override
    public void undo() {
        device.off();
    }
}
