package me.zhang.varargs;

import java.util.Arrays;

/**
 * Created by Zhang on 2015/6/11 ÏÂÎç 2:04 .
 */
public class Sub extends Base {

    @Override
    public void calc(int a, int[] b) {
        System.out.println(a + " /// " + Arrays.toString(b));
    }

    public void calc(int a, int b) {
        System.out.println(a + " /// " + b);
    }

    public void calc(int a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
//        sub.calc(1, 2, 3);
        sub.calc(1, 2);
        sub.calc(1);
        sub.calc(1, new int[]{2, 3});

        Base base = new Sub();
        base.calc(1, 2, 3);
        base.calc(1, 2);
        base.calc(1);
        base.calc(1, new int[]{2, 3});
    }

}
