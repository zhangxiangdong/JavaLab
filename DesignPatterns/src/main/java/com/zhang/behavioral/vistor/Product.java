package com.zhang.behavioral.vistor;

/**
 * Created by Zhang on 12/9/2016 11:19 PM.
 */
public abstract class Product implements Visitable {

    protected double price;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
