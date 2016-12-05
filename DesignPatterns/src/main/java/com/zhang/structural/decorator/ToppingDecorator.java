package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 10:55 PM.
 * <p>
 * Has a "Has a" relationship with Pizza. This is an
 * Aggregation Relationship
 */
abstract public class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    // Assigns the type instance to this attribute
    // of a Pizza

    // All decorators can dynamically customize the Pizza
    // instance PlainPizza because of this
    public ToppingDecorator(Pizza tempPizza) {
        this.tempPizza = tempPizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}
