package me.zhang.intruduction;

import me.zhang.intruduction.behavior.FlyBehavior;
import me.zhang.intruduction.behavior.QuackBehavior;

/**
 * Created by Zhang on 10/3/2015 10:40 下午.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

}
