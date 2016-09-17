package me.zhang.combining.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li on 1/24/2016 4:41 PM.
 */
public class Observable implements QuackObservable {

    List<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}
