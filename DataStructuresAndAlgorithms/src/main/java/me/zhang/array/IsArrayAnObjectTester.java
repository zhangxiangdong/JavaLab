package me.zhang.array;

/**
 * Created by zhangxiangdong on 2017/5/4.
 */
public class IsArrayAnObjectTester {

    public static void main(String[] args) {
        int[] anArray = {0, 1, 2, 3, 4, 5};
        System.out.println(anArray.getClass()); // "class [I"
        System.out.println(anArray.getClass().getSuperclass()); // "class java.lang.Object"
    }

}
