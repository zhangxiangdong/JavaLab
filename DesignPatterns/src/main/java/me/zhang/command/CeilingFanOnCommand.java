package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 10:03 下午.
 */
public class CeilingFanOnCommand implements Command{

    CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {

    }
}
