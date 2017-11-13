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

        System.out.println(min(2, 1, 4, 3, 7, 6, 5, 8, 9));
        System.out.println(min(3.1, 2.0, 4.3));
    }

    @SafeVarargs
    private static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    @SafeVarargs
    private static <T extends Number & Comparable> T min(T... a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T smallest = a[0];
        for (T t : a) {
            if (t.compareTo(smallest) < 0) {
                smallest = t;
            }
        }
        return smallest;
    }

}
