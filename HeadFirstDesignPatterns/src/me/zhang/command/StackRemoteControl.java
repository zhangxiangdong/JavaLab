package me.zhang.command;

import java.util.Stack;

/**
 * Created by Zhang on 11/7/2015 9:34 下午.
 */
public class StackRemoteControl {

    Command[] onCommands;
    Command[] offCommands;
    Stack<Command> undoCommands; // 记录每一个被执行的命令
    Command undoCommand;

    public StackRemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommands = new Stack<>();
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
        undoCommands.add(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
        undoCommands.add(offCommands[slot]);
    }

    public void undoButtonWasPushed() {
        if (!undoCommands.isEmpty()) {
            undoCommand = undoCommands.pop();
            undoCommand.undo();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            builder
                    .append("[slot ")
                    .append(i)
                    .append("] ")
                    .append(onCommands[i].getClass().getSimpleName())
                    .append("   ")
                    .append(offCommands[i].getClass().getSimpleName())
                    .append("\n");
        }
        builder
                .append("[undo]")
                .append(undoCommand.getClass().getSimpleName())
                .append("\n");
        return builder.toString();
    }
}
