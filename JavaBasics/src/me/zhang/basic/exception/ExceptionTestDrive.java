package me.zhang.basic.exception;

/**
 * Created by Li on 4/17/2016 9:31 AM.
 */
public class ExceptionTestDrive {
    public static void main(String[] args) {
        try {
            callDoOne(); // catch exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doOne() throws Exception {
        // throws exception
    }

    public static void callDoOne() throws Exception {
        doOne(); // throws away
    }
}
