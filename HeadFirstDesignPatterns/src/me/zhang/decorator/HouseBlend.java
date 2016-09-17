package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:21 下午.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
