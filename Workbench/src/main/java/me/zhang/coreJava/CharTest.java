package me.zhang.coreJava;

/**
 * Created by Zhang on 9/30/2017 10:17 AM.
 */
public class CharTest {

    public static void main(String[] args) {
        // Print out CJK Radicals Supplement characters
        for (int i = '\u2E80'; i <= '\u2EFF'; i++) {
            System.out.print((char) i);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

}
