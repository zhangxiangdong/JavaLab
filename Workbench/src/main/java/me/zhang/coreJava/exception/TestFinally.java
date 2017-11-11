package me.zhang.coreJava.exception;

/**
 * Created by Zhang on 2017/11/11 18:28.
 */
public class TestFinally {

    public static void main(String[] args) {
        System.out.println(calc()); // print: 2
    }

    private static int calc() {
        try {
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // this will override return 1...
            return 2;
        }
    }


}
