package me.zhang.combining.adapter;

import me.zhang.combining.Goose;
import me.zhang.combining.Quackable;
import me.zhang.combining.observer.Observer;

/**
 * Created by Li on 1/24/2016 1:51 PM.
 * <p/>
 * Adapter
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
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
