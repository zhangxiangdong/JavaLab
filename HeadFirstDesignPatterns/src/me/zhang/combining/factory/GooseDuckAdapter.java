package me.zhang.combining.factory;

import me.zhang.combining.Quackable;
import me.zhang.combining.observer.Observer;

/**
 * Created by Li on 1/24/2016 2:47 PM.
 */
public class GooseDuckAdapter implements Quackable {

    Honkable goose;

    public GooseDuckAdapter(Honkable goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
