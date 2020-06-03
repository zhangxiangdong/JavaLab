package me.zhang.coreJava;

/**
 * Created by Zhang on 9/30/2017 3:53 PM.
 */
public class BitwiseTest {

    public static void main(String[] args) {
        System.out.println(fourthBitFromRigth(12));

        System.out.println(fourthBitFromRigth(7));

        System.out.println(kthBitFromRight(12, 3));

        System.out.println(kthBitFromRight(7, 3));
    }

    private static int fourthBitFromRigth(int n) {
        return (n & 0b1000) / 0b1000;
    }

    private static int kthBitFromRight(int n, int k) {
        return (n & (1 << k)) >> k;
    }

}
