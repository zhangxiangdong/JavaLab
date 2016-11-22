package me.zhang.factory.pizza;

import me.zhang.factory.Pizza;
import me.zhang.factory.PizzaIngredientFactory;

/**
 * Created by Zhang on 10/27/2015 9:35 下午.
 */
public class VeggiePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        veggies = ingredientFactory.createVeggies();
    }
}
