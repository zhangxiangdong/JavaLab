package me.zhang.basic.exception;

/**
 * Created by Li on 4/17/2016 9:38 AM.
 */
public class SubclassExceptionTestDrive {
    public static void main(String[] args) {
        try {
            callDoOne(); // catch Exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doOne() throws MyException {
        // throw MyException;
    }

    public static void callDoOne() throws Exception {
        doOne();
        // throw Exception;
    }
}

class MyException extends Exception {
    // Subclass Exception
}