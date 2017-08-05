package me.zhang.dsa;

import org.junit.Assert;
import org.junit.Test;

public class BitwiseTest {

    private Bitwise bitwise = new Bitwise();

    @Test
    public void numberOfOne() throws Exception {
        System.out.println(Integer.toBinaryString(-8));
        Assert.assertEquals(29, bitwise.numberOf1(-8));

        System.out.println(String.format("%32s", Integer.toBinaryString(0)).replace(' ', '0'));
        Assert.assertEquals(0, bitwise.numberOf1(0));

        System.out.println(String.format("%32s", Integer.toBinaryString(9)).replace(' ', '0'));
        Assert.assertEquals(2, bitwise.numberOf1(9));
    }

    @Test
    public void numberOfOneEfficient() throws Exception {
        System.out.println(Integer.toBinaryString(-6));
        Assert.assertEquals(30, bitwise.numberOf1Efficiently(-6));

        System.out.println(String.format("%32s", Integer.toBinaryString(0)).replace(' ', '0'));
        Assert.assertEquals(0, bitwise.numberOf1Efficiently(0));

        System.out.println(String.format("%32s", Integer.toBinaryString(9)).replace(' ', '0'));
        Assert.assertEquals(2, bitwise.numberOf1Efficiently(9));
    }

}