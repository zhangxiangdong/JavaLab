package me.zhang.basic.exception;

/**
 * Created by Li on 4/17/2016 9:52 AM.
 */
public class RuntimeExceptions {

    public RuntimeExceptions() throws Exception {
        // Constructor can also throw Exceptions
    }

    public static void main(String[] args) {
        doSomething(new Object()); // works well

        try {
            doSomething(null); // try to catch it
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doSomething(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("obj can not be null");
    }
}
