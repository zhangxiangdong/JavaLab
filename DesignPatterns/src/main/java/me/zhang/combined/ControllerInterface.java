package me.zhang.combined;

/**
 * Created by Li on 3/6/2016 10:45 AM.
 */
public interface ControllerInterface {
    void start();

    void stop();

    void setBPM(int bpm);

    void increaseBPM();

    void decreaseBPM();
}
