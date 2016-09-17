package me.zhang.combined;

/**
 * Created by Li on 3/6/2016 1:35 PM.
 */
public interface HeartModelInterface {
    int getHeartRate();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
