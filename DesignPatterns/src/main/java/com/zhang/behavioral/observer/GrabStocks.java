package com.zhang.behavioral.observer;

/**
 * Created by Zhang on 12/4/2016 7:15 PM.
 */
public class GrabStocks {

    public static void main(String[] args) {
        // Create the Subject object
        // It will handle updating all observers
        // as well as deleting and adding them
        StockGrabber stockGrabber = new StockGrabber();
        // Create an Observer that will be sent updates from Subject
        StockObserver observer1 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setGoogPrice(676.40);
        // Delete one of the observers
        stockGrabber.unregisterObserver(observer1);

        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(200.21);

        stockGrabber.unregisterObserver(observer2);

        stockGrabber.setGoogPrice(666.90);
    }

}
