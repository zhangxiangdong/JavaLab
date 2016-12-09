package com.zhang.behavioral.vistor;

import java.text.DecimalFormat;

/**
 * Created by Zhang on 12/9/2016 11:17 PM.
 * <p>
 * Concrete Visitor Class
 */
public class TaxVisitor implements Visitor {

    // This formats the item prices to 2 decimal places

    DecimalFormat df = new DecimalFormat("#.##");

    // This is created so that each item is sent to the
    // right version of visit() which is required by the
    // Visitor interface and defined below

    public TaxVisitor() {
    }

    // Calculates total price based on this being taxed
    // as a liquor item
    @Override
    public double visit(Liquor liquor) {
        System.out.println("Liquor Item: Price with Tax");
        double price = liquor.getPrice();
        return Double.parseDouble(df.format((price * .18) + price));
    }

    // Calculates total price based on this being taxed
    // as a tobacco item
    @Override
    public double visit(Tobacco tobacco) {
        System.out.println("Tobacco Item: Price with Tax");
        double price = tobacco.getPrice();
        return Double.parseDouble(df.format((price * .32) + price));
    }

    // Calculates total price based on this being taxed
    // as a necessity item
    @Override
    public double visit(Neccesity neccesity) {
        System.out.println("Necessity Item: Price with Tax");
        return Double.parseDouble(df.format(neccesity.getPrice()));
    }
}
