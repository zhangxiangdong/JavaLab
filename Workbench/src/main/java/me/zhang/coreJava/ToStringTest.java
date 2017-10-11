package me.zhang.coreJava;

/**
 * Created by Zhang on 2017/10/11 21:13.
 */
public class ToStringTest {

    public static void main(String[] args) {
        System.out.println(System.out);

        // primary type
        byte[] b = {2, 1, 4};
        System.out.println(b);
        short[] s = {20, 1, 24};
        System.out.println(s);
        int[] i = {128, 200, 13};
        System.out.println(i);
        long[] l = {1280000000000000000L, 200, 13};
        System.out.println(l);
        float[] f = {2.1f, 3.2f, 236.3f};
        System.out.println(f);
        double[] d = {1232.1, 3.2, 2.3245533221};
        System.out.println(d);
    }

}
