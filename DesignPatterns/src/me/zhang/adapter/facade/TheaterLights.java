package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/11/2015 10:22 下午.
 */
public class TheaterLights {

    public void on() {
        System.out.println("Theater Lights On");
    }

    public void off() {
        System.out.println("Theater Lights Off");
    }

    public void dim(int i) {
        System.out.println("Theater Lights Dim " + i);
    }

}
