package com.zhang.behavioral.observer;

/**
 * Created by Zhang on 12/4/2016 7:10 PM.
 */
public class StockObserver implements Observer {

    private static int observerTracker = 0;
    // Used to track the observers
    private int observerId;

    private double ibmPrice;
    private double googPrice;

    public StockObserver(Subject stockGrabber) {
        observerId = ++observerTracker;
        System.out.println("New Observer: " + observerId);
        stockGrabber.registerObserver(this);
    }

    @Override
    public void update(double ibmPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.googPrice = googPrice;
        printStockPrice();
    }

    private void printStockPrice() {
        System.out.println("Observer Id: " + observerId);
        System.out.println("\tIBM: " + ibmPrice + ", Google: " + googPrice);
    }
}
