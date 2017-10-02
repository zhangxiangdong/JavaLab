package me.zhang.coreJava;

/**
 * Created by Zhang on 10/2/2017 2:53 PM.
 */
public class LoopTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // i no longer defined here

        int i;
        for (i = 10; i > 0; i--) {
            System.out.println(i);
        }
        // i still defined here

        // Take Care!
        // Endless Loop!
        for (double d = 0; d != 1; d += .1) {
            System.out.println(d);
        }
    }

}
