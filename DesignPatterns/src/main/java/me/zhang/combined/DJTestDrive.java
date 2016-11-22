package me.zhang.combined;

/**
 * Created by Li on 3/6/2016 1:27 PM.
 */
public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        new BeatController(model);
    }
}
