package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 11:02 下午.
 */
public class Tall extends SizeDecorator {

    Beverage beverage;

    public Tall(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
