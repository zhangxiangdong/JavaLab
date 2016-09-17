package me.zhang.command;

/**
 * Created by Zhang on 11/8/2015 8:26 下午.
 */
public class TVOnCommand implements Command {

    TV tv;
    Command preCommand;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
