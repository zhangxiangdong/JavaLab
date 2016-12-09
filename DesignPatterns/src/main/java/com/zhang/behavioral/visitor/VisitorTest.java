package com.zhang.behavioral.visitor;

/**
 * Created by Zhang on 12/9/2016 11:16 PM.
 */
public class VisitorTest {

    public static void main(String[] args) {
        Visitor taxVisitor = new TaxVisitor();
        Visitor taxHolidayVisitor = new TaxHolidayVisitor();

        Necessity juice = new Necessity(12.3);
        System.out.println(juice.accept(taxVisitor));
        System.out.println(juice.accept(taxHolidayVisitor));

        Liquor vodka = new Liquor(23.22);
        System.out.println(vodka.accept(taxVisitor));
        System.out.println(vodka.accept(taxHolidayVisitor));

        Tobacco cigars = new Tobacco(19.99);
        System.out.println(cigars.accept(taxVisitor));
        System.out.println(cigars.accept(taxHolidayVisitor));
    }

}
