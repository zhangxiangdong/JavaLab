package me.zhang.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class FrancTest {

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    public void testFrancEquality() {
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
    }

}
