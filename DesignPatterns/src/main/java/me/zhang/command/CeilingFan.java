package me.zhang.command;

/**
 * Created by Zhang on 11/7/2015 9:59 下午.
 */
public class CeilingFan {

    public static final int HIGH    = 3;
    public static final int MEDIUM  = 2;
    public static final int LOW     = 1;
    public static final int OFF     = 0;

    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("Ceiling Fan is on High");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("Ceiling Fan is on Medium");
    }

    public void low() {
        speed = LOW;
        System.out.println("Ceiling Fan is on Low");
    }

    public void on() {
        System.out.println("Ceiling Fan is On");
    }

    public void off() {
        speed = OFF;
        System.out.println("Ceiling Fan is Off");
    }

    public int getSpeed() {
        return speed;
    }

}
