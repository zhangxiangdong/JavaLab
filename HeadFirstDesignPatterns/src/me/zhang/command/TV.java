package me.zhang.command;

/**
 * Created by Zhang on 11/8/2015 8:24 下午.
 */
public class TV {

    String location;

    public TV() {
    }

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("TV is On");
    }

    public void off() {
        System.out.println("TV is Off");
    }

}
