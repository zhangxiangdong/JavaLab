package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 9:43 下午.
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD(new CD());
        stereo.setVolume(12);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
