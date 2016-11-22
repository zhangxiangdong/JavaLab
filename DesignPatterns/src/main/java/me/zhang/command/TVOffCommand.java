package me.zhang.command;

/**
 * Created by Zhang on 11/8/2015 8:32 下午.
 */
public class TVOffCommand implements Command {

    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
