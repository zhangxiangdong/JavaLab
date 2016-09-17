package me.zhang.combining.observer;

/**
 * Created by Li on 1/24/2016 5:08 PM.
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.printf("\tQuackologist: %s just quacked.%n", duck);
    }
}
