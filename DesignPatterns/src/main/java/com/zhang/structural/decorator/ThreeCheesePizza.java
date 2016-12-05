package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 10:53 PM.
 */
public class ThreeCheesePizza implements Pizza {

    // Inheritance is static while composition is dynamic
    // Through composition I'll be able to add new functionality
    // by writing new code rather than by changing current code

    private String description = "Mozzarella, Fontina, Parmesan Cheese Pizza";
    private double cost = 10.50;

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setCost(double newCost) {
        cost = newCost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
