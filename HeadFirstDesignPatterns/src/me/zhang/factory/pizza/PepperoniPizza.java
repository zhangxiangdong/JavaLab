package me.zhang.factory.pizza;

import me.zhang.factory.Pizza;
import me.zhang.factory.PizzaIngredientFactory;

/**
 * Created by Zhang on 10/27/2015 9:34 下午.
 */
public class PepperoniPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        pepperoni = ingredientFactory.createPepperoni();
    }
}
