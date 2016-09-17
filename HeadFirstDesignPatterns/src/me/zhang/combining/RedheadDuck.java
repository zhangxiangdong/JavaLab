package me.zhang.combining;

import me.zhang.combining.observer.Observable;
import me.zhang.combining.observer.Observer;

/**
 * Created by Li on 1/24/2016 1:43 PM.
 */
public class RedheadDuck implements Quackable {

    Observable observable;

    public RedheadDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return "Red Head Duck";
    }
}
