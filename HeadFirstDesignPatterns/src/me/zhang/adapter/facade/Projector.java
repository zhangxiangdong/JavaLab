package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/11/2015 10:24 下午.
 */
public class Projector {

    DvdPlayer dvdPlayer;

    public void on() {
        System.out.println("Projector On");
    }

    public void off() {
        System.out.println("Projector Off");
    }

    public void tvMode() {
        System.out.println("Projector On TV Mode");
    }

    public void wideScreenMode() {
        System.out.println("Projector On Wide Screen Mode");
    }

    public void setInput(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }
}
