package me.zhang.adapter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Zhang on 11/11/2015 9:06 下午.
 */
public class IteratorEnumerationTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> iterator = list.iterator();
        IteratorEnumeration<String> enumation = new IteratorEnumeration<>(iterator);
        while (enumation.hasMoreElements()) {
            System.out.println(enumation.nextElement());
        }
    }

}
