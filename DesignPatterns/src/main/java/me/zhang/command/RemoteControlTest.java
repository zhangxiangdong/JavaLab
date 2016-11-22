package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 8:41 下午.
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        /* Light */
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(lightOff);
        remote.buttonWasPressed();

        /* Garage Door */
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();
    }

}
