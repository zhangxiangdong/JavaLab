package me.zhang.dataStructure.applications;

import me.zhang.dataStructure.ArrayStack;
import me.zhang.dataStructure.Stack;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/6/2.
 */
public class ArrayOperator {

    public void reverse(int[] a) {
        Stack<Integer> exchanger = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++) {
            exchanger.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = exchanger.pop();
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(a));

        ArrayOperator operator = new ArrayOperator();
        operator.reverse(a);
        System.out.println(Arrays.toString(a));
    }

}
