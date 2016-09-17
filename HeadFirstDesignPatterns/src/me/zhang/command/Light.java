package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 8:37 下午.
 */
public class Light {

    String location;

    public Light() {
    }

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Light is Off");
    }
}
