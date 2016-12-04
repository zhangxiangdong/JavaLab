package com.zhang.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 12/4/2016 7:07 PM.
 */
public class StockGrabber implements Subject {

    private List<Observer> observers;
    private double ibmPrice;
    private double googPrice;

    public StockGrabber() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregisterObserver(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Delete Observer Index: " + observerIndex);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ibmPrice, googPrice);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}
