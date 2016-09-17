package me.zhang.combined;

/**
 * Created by Li on 3/6/2016 1:41 PM.
 */
public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        new HeartController(heartModel);
    }
}
