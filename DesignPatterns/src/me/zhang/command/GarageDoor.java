package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 8:47 下午.
 */
public class GarageDoor {

    String location;

    public GarageDoor() {
    }

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println("Garage Door is Open");
    }

    public void down() {
        System.out.println("Garage Door was Closed");
    }

    public void stop() {
        System.out.println("Garage Door Stop");
    }

    public void lightOn() {
        System.out.println("Garage Light On");
    }

    public void lightOff() {
        System.out.println("Garage Light Off");
    }

}
