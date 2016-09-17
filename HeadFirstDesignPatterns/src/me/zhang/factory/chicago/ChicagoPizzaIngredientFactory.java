package me.zhang.factory.chicago;

import me.zhang.factory.PizzaIngredientFactory;
import me.zhang.factory.ingredient.*;
import me.zhang.factory.ny.SlicedPepperoni;
import me.zhang.factory.ingredient.veggie.BlackOlives;
import me.zhang.factory.ingredient.veggie.EggPlant;
import me.zhang.factory.ingredient.veggie.Spinach;

/**
 * Created by Zhang on 11/3/2015 8:41 下午.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{
                new BlackOlives(),
                new Spinach(),
                new EggPlant()
        };
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
