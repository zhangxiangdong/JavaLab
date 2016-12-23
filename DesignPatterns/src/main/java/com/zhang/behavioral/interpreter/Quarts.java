package com.zhang.behavioral.interpreter;

/**
 * Created by Zhang on 2016/12/23 22:56.
 */
public class Quarts extends Expression {

    public String gallons(double quantity) {
        return Double.toString(quantity / 4);
    }

    public String quarts(double quantity) {
        return Double.toString(quantity);
    }

    public String pints(double quantity) {
        return Double.toString(quantity * 2);
    }

    public String cups(double quantity) {
        return Double.toString(quantity * 4);
    }

    public String tablespoons(double quantity) {
        return Double.toString(quantity * 64);
    }

}
