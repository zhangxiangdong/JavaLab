package com.zhang.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 12/13/2016 10:06 PM.
 */
public class PlayWithRemote {

    public static void main(String[] args) {
        ElectronicDevice newDevice = TVRemote.getDevice();

        Command turnTVOn = new TurnTVOn(newDevice);

        DeviceButton onPressed = new DeviceButton(turnTVOn);
        onPressed.press();

        Command offCommand = new TurnTVOff(newDevice);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        Command volUpCommand = new TurnTVUp(newDevice);
        onPressed = new DeviceButton(volUpCommand);
        onPressed.press();
        onPressed.press();
        onPressed.press();

        Command volDownCommand = new TurnTVDown(newDevice);
        onPressed = new DeviceButton(volDownCommand);
        onPressed.press();
        onPressed.press();

        ElectronicDevice theTv = TVRemote.getDevice();
        ElectronicDevice theRadio = new Radio();
        List<ElectronicDevice> devices = new ArrayList<>();
        devices.add(theTv);
        devices.add(theRadio);
        Command turnItAllOffCommand = new TurnItAllOff(devices);
        onPressed = new DeviceButton(turnItAllOffCommand);
        onPressed.press();
        onPressed.pressUndo();

    }

}
