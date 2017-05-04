package me.zhang.array;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/5/4.
 */
public class IsArrayAnObjectTester {

    public static void main(String[] args) {
        int[] anArray = {0, 1, 2, 3, 4, 5};
        System.out.println(anArray.getClass()); // "class [I"
        System.out.println(anArray.getClass().getSuperclass()); // "class java.lang.Object"

        int[] anotherArray = {0, 1, 2, 3, 4, 5};
        System.out.println(anArray == anotherArray); // "false"
        System.out.println(Arrays.equals(anArray, anotherArray)); // "true"

        int[][] twoDArray = {{0, 1}, {2, 3}, {4, 5}};
        int[][] anotherTwoDArray = {{0, 1}, {2, 3}, {4, 5}};
        System.out.println(twoDArray == anotherTwoDArray); // "false"
        System.out.println(Arrays.equals(twoDArray, anotherTwoDArray)); // "false"
        System.out.println(Arrays.deepEquals(twoDArray, anotherTwoDArray)); // "true"
    }

}
