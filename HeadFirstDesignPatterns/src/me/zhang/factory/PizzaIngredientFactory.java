package me.zhang.factory;

import me.zhang.factory.ingredient.*;

/**
 * Created by Zhang on 11/3/2015 8:28 下午.
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();

}
