package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:16 下午.
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
