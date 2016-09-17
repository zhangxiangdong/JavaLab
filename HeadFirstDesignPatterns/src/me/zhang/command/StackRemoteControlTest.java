package me.zhang.command;

/**
 * Created by Zhang on 11/8/2015 8:54 下午.
 */
public class StackRemoteControlTest {

    public static void main(String[] args) {
        StackRemoteControl stackRemoteControl = new StackRemoteControl();

        /* Receivers */
        Light light = new Light();
        Stereo stereo = new Stereo();
        TV tv = new TV();

        /* Commands */
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        /* Set Commands */
        stackRemoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        stackRemoteControl.setCommand(1, stereoOnWithCDCommand, stereoOffCommand);
        stackRemoteControl.setCommand(2, tvOnCommand, tvOffCommand);

        /* Tests */
        stackRemoteControl.onButtonWasPushed(0);
        stackRemoteControl.offButtonWasPushed(0);
        stackRemoteControl.onButtonWasPushed(0);
        stackRemoteControl.offButtonWasPushed(0);
        System.out.println(stackRemoteControl);
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();

        stackRemoteControl.onButtonWasPushed(1);
        stackRemoteControl.offButtonWasPushed(1);
        System.out.println(stackRemoteControl);
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();
        stackRemoteControl.undoButtonWasPushed();

        stackRemoteControl.onButtonWasPushed(2);
        stackRemoteControl.offButtonWasPushed(2);
        System.out.println(stackRemoteControl);
        stackRemoteControl.undoButtonWasPushed();
    }

}
