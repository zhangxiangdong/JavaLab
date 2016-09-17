package me.zhang.command;

/**
 * Created by Zhang on 11/8/2015 8:31 下午.
 */
public class HottubOnCommand implements Command{

    Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.on();
    }

    @Override
    public void undo() {
        hottub.off();
    }
}
