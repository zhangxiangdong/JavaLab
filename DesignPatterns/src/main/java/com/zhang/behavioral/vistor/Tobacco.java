package com.zhang.behavioral.vistor;

/**
 * Created by Zhang on 12/9/2016 11:10 PM.
 */
public class Tobacco extends Product {

    public Tobacco(double price) {
        super(price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
