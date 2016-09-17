package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 9:44 下午.
 */
public class Stereo {

    String location;

    public Stereo() {
    }

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("Stero On");
    }

    public void off() {
        System.out.println("Stero Off");
    }

    public void setCD(CD cd) {
        System.out.println("Stero CD set");
    }

    public void setDVD() {
        System.out.println("Stero DVD set");
    }

    public void setRadio() {
        System.out.println("Stero Radio set");
    }

    public void setVolume(int i) {
        System.out.println("Stero Volume set");
    }
}
