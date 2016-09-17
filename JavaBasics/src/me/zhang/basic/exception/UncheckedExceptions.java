package me.zhang.basic.exception;

import java.util.Scanner;

/**
 * Created by Li on 4/16/2016 9:52 PM.
 */
public class UncheckedExceptions {
    public static void main(String[] args) {
        arithmeticException();
    }

    private static void arithmeticException() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        try {
            System.out.println("a / b = " + a / b);
        } catch (ArithmeticException e) {
            System.out.println("/ by zero");
        }
        System.out.println("hehe~");
        in.close();
    }

}
