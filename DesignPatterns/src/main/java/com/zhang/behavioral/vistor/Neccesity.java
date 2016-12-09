package com.zhang.behavioral.vistor;

/**
 * Created by Zhang on 12/9/2016 11:10 PM.
 */
public class Neccesity extends Product {

    public Neccesity(double price) {
        super(price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
