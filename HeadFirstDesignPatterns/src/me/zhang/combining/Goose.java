package me.zhang.combining;

import me.zhang.combining.factory.Honkable;

/**
 * Created by Li on 1/24/2016 1:51 PM.
 */
public class Goose implements Honkable {
    @Override
    public void honk() {
        System.out.println("Honk");
    }
}
