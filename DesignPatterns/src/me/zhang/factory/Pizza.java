package me.zhang.factory;

import me.zhang.factory.ingredient.*;

import java.util.ArrayList;

/**
 * Created by Zhang on 10/27/2015 9:33 下午.
 */
public abstract class Pizza {

    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;
    protected ArrayList<String> toppings = new ArrayList<>();

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public abstract void prepare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
