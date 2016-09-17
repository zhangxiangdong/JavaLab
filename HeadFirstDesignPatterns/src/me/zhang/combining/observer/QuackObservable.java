package me.zhang.combining.observer;

/**
 * Created by Li on 1/24/2016 4:37 PM.
 */
public interface QuackObservable {
    void registerObserver(Observer observer);

    void notifyObservers();
}
