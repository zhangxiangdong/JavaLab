package com.zhang.behavioral.observer;

/**
 * Created by Zhang on 12/4/2016 7:05 PM.
 */
public interface Subject {

    void registerObserver(Observer newObserver);

    void unregisterObserver(Observer deleteObserver);

    void notifyObserver();

}
