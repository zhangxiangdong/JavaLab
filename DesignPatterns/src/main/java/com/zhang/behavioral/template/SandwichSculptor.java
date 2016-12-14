package com.zhang.behavioral.template;

/**
 * Created by Zhang on 12/14/2016 10:19 PM.
 */
public class SandwichSculptor {

    public static void main(String[] args) {
        Hoagie italianHoagie = new ItalianHoagie();
        italianHoagie.makeSandwich();

        Hoagie cust13Hoagie = new VeggieHoagie();
        cust13Hoagie.makeSandwich();
    }

}
