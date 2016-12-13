package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:03 PM.
 */
public class TurnTVUp implements Command {
    ElectronicDevice device;

    public TurnTVUp(ElectronicDevice newDevice) {
        this.device = newDevice;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }

    @Override
    public void undo() {
        device.volumeDown();
    }
}
