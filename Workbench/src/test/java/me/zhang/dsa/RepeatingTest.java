package me.zhang.dsa;

import org.junit.Assert;
import org.junit.Test;

public class RepeatingTest {

    private Repeating repeating = new Repeating();

    @Test
    public void addFromOneToN() throws Exception {
        int expected = (1 + 100) * 100 >>> 1;
        Assert.assertEquals(5050, expected);

        int actual = repeating.addFromOneToNRecursively(100);
        Assert.assertEquals(expected, actual);

        actual = repeating.addFromOneToNCyclically(100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fibonacci() {
        // https://en.wikipedia.org/wiki/Fibonacci_number
        int[] fibonacci = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        int expected = fibonacci[6];
        Assert.assertEquals(expected, repeating.fibonacciRecursively(6));
        Assert.assertEquals(expected, repeating.fibonacciCyclically(6));

        for (int i = 0; i < fibonacci.length; i++) {
            expected = fibonacci[i];
            Assert.assertEquals(expected, repeating.fibonacciRecursively(i));
            Assert.assertEquals(expected, repeating.fibonacciCyclically(i));
        }

        // System.out.println(repeating.fibonacciRecursively(100));

    }

    @Test
    public void frogJump() {
        // https://en.wikipedia.org/wiki/Geometric_progression
        int[] steps = {1, 1, 2, 4, 8, 16, 32, 64, 128, 256};
        int expected = steps[9];
        Assert.assertEquals(expected, repeating.frogJump(9));

        for (int i = 0; i < steps.length; i++) {
            expected = steps[i];
            Assert.assertEquals(expected, repeating.frogJump(i));
        }
    }

}