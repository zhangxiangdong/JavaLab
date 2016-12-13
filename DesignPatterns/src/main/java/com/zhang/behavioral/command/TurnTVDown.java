package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:03 PM.
 */
public class TurnTVDown implements Command {
    ElectronicDevice device;

    public TurnTVDown(ElectronicDevice newDevice) {
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.volumeDown();
    }

    @Override
    public void undo() {
        device.volumeUp();
    }
}
