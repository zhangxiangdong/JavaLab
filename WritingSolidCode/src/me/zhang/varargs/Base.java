package me.zhang.varargs;

import java.util.Arrays;

/**
 * Created by Zhang on 2015/6/11 обнГ 2:04 .
 */
public class Base {

    public void calc(int a, int... b) {
        System.out.println(a + " /// " + Arrays.toString(b));
    }

}
