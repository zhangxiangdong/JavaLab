package me.zhang.factory.ny;

import me.zhang.factory.*;
import me.zhang.factory.pizza.CheesePizza;
import me.zhang.factory.pizza.ClamPizza;
import me.zhang.factory.pizza.PepperoniPizza;
import me.zhang.factory.pizza.VeggiePizza;

/**
 * Created by Zhang on 10/27/2015 9:57 下午.
 * <p>
 * 封装的知识是关于如何制作纽约风味的比萨
 */
public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if ("cheese".equals(type)) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggies Pizza");
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clams Pizza");
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
