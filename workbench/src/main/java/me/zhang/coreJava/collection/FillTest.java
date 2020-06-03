package me.zhang.coreJava.collection;

import java.util.*;

/**
 * Created by zhangxiangdong on 2017/12/6.
 */
public class FillTest {

    public static void main(String[] args) {
        List<String> array = new ArrayList<>(100000);
        List<String> linked = new LinkedList<>(Arrays.asList(new String[100000]));

        fillWithRandomAccess(array, "Hi");
        fillWithRandomAccess(linked, "Hi");

        fillWithIterator(array, "Hi");
        fillWithIterator(linked, "Hi");
    }

    private static <T> void fillWithRandomAccess(List<? super T> list, T obj) {
        long startTime = System.nanoTime();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, obj);
        }

        long endTime = System.nanoTime();

        System.out.println("Time Consumed: " + (endTime - startTime) + " ns");
    }

    private static <T> void fillWithIterator(List<? super T> list, T obj) {
        long startTime = System.nanoTime();

        ListIterator<? super T> itr = list.listIterator();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            itr.next();
            itr.set(obj);
        }

        long endTime = System.nanoTime();
        System.out.println("Time Consumed: " + (endTime - startTime) + " ns");
    }

}
