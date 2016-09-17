package me.zhang.factory.ny;

import me.zhang.factory.PizzaIngredientFactory;
import me.zhang.factory.ingredient.*;
import me.zhang.factory.ingredient.veggie.Garlic;
import me.zhang.factory.ingredient.veggie.Mushroom;
import me.zhang.factory.ingredient.veggie.Onion;
import me.zhang.factory.ingredient.veggie.RedPepper;

/**
 * Created by Zhang on 11/3/2015 8:34 下午.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{
                new Garlic(),
                new Onion(),
                new Mushroom(),
                new RedPepper()
        };
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
