package me.zhang.observer;

/**
 * Created by Zhang on 10/8/2015 10:41 下午.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
