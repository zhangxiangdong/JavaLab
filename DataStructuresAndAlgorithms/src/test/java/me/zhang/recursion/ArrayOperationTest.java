package me.zhang.recursion;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/5/22.
 */
public class ArrayOperationTest {
    @Test
    public void reverseArrayRecursion() throws Exception {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int b[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        ArrayOperation operation = new ArrayOperation();
        operation.reverseArray(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        System.out.println();

        System.out.println(Arrays.toString(b));
        operation.reverseArray(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void reverseArrayLoop() throws Exception {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int b[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        ArrayOperation operation = new ArrayOperation();
        operation.reverseArray(a);
        System.out.println(Arrays.toString(a));

        System.out.println();

        System.out.println(Arrays.toString(b));
        operation.reverseArray(b);
        System.out.println(Arrays.toString(b));
    }

}