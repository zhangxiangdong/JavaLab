package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/11/2015 10:20 下午.
 */
public class Amplifier {

    private DvdPlayer dvd;
    private int volume;

    public void on() {
        System.out.println("Amplifier On");
    }

    public void off() {
        System.out.println("Amplifier Off");
    }


    public void setDvd(DvdPlayer dvd) {
        this.dvd = dvd;
    }

    public void setSurroundSound() {
        System.out.println("Surround Sound Set");
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
