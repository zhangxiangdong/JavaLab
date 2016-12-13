package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:05 PM.
 */
public class DeviceButton {

    Command theCommand;

    public DeviceButton(Command theCommand) {
        this.theCommand = theCommand;
    }

    public void press() {
        theCommand.execute();
    }

    public void pressUndo() {
        theCommand.undo();
    }

}
