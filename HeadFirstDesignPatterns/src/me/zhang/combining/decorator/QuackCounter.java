package me.zhang.combining.decorator;

import me.zhang.combining.Quackable;
import me.zhang.combining.observer.Observer;

/**
 * Created by Li on 1/24/2016 2:10 PM.
 * <p/>
 * Decorator
 */
public class QuackCounter implements Quackable {

    Quackable duck;
    static int numOfQuacks = 0;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numOfQuacks++;
    }

    public static int getNumOfQuacks() {
        return numOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

    @Override
    public String toString() {
        return duck.toString();
    }
}
