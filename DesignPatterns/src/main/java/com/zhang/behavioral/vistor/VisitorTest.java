package com.zhang.behavioral.vistor;

/**
 * Created by Zhang on 12/9/2016 11:16 PM.
 */
public class VisitorTest {

    public static void main(String[] args) {
        Visitor taxVisitor = new TaxVisitor();

        Neccesity juice = new Neccesity(12.3);
        System.out.println(juice.accept(taxVisitor));

        Liquor vodka = new Liquor(23.22);
        System.out.println(vodka.accept(taxVisitor));

        Tobacco cigars = new Tobacco(19.99);
        System.out.println(cigars.accept(taxVisitor));
    }

}
