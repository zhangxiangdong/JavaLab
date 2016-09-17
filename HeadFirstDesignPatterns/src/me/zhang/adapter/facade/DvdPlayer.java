package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/11/2015 10:22 下午.
 */
public class DvdPlayer {

    Amplifier amplifier;

    public void on() {
        System.out.println("DVD Player On");
    }

    public void off() {
        System.out.println("DVD Player Off");
    }

    public void eject() {
        System.out.println("DVD Player Ejected");
    }

    public void pause() {
        System.out.println("DVD Player Pause");
    }

    public void play(Movie movie) {
        System.out.println("DVD Player Playing Movie " + movie.name);
    }

    public void setSurroundAudio() {
    }

    public void setTwoChannelAudio() {
    }

    public void stop() {
        System.out.println("DVD Player Stopped");
    }


}
