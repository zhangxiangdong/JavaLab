package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/13.
 */
public class GenericMethod {

    public static void main(String[] args) {
        System.out.println(GenericMethod.<Integer>getMiddle(1, 2, 3));
        System.out.println(GenericMethod.getMiddle("A", "B", "C"));

        // double middle = getMiddle(3.14, 2, 1000000000000L);
        System.out.println(getMiddle(3.14, 2, 1000000000000L));
    }

    @SafeVarargs
    private static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

}
