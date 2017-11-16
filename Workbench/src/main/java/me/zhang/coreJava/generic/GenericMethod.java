package me.zhang.coreJava.generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        // inspect("Hi"); // ERROR!!!
        inspect(2_000);

        Character[] characters = new Character[]{'a', 'b', 'c', 'd', 'e'};
        int count = countGreaterThan(characters, 'b');
        System.out.println(count); // 3

        // The common parent of Box<Integer> and Box<Number> is Object.
        // Box<Integer> iBox = new Box<>(123);
        // System.out.println(getNumber(iBox); // ERROR!!!
        System.out.println(getNumber(new Box<>(12.0)));

        List<String> emptyList = Collections.<String>emptyList();
        processStringList(emptyList);
        processStringList(Collections.emptyList()); // error on java 7: List<Object> cannot be converted to List<String>

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sumOfNumber(integers));

        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println(sumOfNumber(doubles));
    }

    private static void processStringList(List<String> target) {

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

    private static <T extends Number> void inspect(T input) {
        System.out.println(input);
    }

    private static <T extends Comparable> int countGreaterThan(T[] ts, T t) {
        if (ts == null) {
            throw new NullPointerException();
        }
        int count = 0;
        for (T t1 : ts) {
            if (t1.compareTo(t) > 0) {
                count++;
            }
        }
        return count;
    }

    private static Number getNumber(Box<Number> nBox) {
        return nBox.getT();
    }

    private static double sumOfNumber(List<? extends Number> numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

}
