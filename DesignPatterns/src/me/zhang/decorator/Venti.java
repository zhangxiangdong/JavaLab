package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 11:04 下午.
 */
public class Venti extends SizeDecorator {

    Beverage beverage;

    public Venti(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
