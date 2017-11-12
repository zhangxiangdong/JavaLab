package me.zhang.coreJava.exception;

/**
 * Created by Zhang on 2017/11/12 9:04.
 */
public class TestAssert {

    public static void main(String[] args) {
        System.out.println(sqrt(12));
        System.out.println(sqrt(-12));
    }

    private static double sqrt(double x) {
        // https://intellij-support.jetbrains.com/hc/en-us/community/posts/207014815-How-to-enable-assert
        //  -ea (or -enableassertions)
        assert x >= 0 : x;
        return Math.sqrt(x);
    }

    private static void anotherSample(int i) {
        assert i >= 0; // precondition
        if (i % 3 == 0) {

        } else if (i % 3 == 1) {

        } else { // (i % 3 == 2) // use commnents as explanation
            assert i % 3 == 2; // assertion would be a better choose here
        }
    }

}
