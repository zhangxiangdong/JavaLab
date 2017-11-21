package me.zhang.coreJava.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/11/21.
 */
public class Test {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "B", "C");
        System.out.println(contains(strings, "B"));
        System.out.println(contains(strings, "E"));
    }

    private static <E> boolean contains(Collection<E> collection, E obj) {
        for (E e : collection) {
            if (e.equals(obj)) {
                return true;
            }
        }
        return false;
    }

}
