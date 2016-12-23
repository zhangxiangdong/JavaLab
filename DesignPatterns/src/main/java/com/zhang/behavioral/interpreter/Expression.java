package com.zhang.behavioral.interpreter;

/**
 * Created by Zhang on 2016/12/23 22:56.
 */
public abstract class Expression {

    public abstract String gallons(double quantity);

    public abstract String quarts(double quantity);

    public abstract String pints(double quantity);

    public abstract String cups(double quantity);

    public abstract String tablespoons(double quantity);

}
