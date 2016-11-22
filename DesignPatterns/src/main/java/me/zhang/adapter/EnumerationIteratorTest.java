package me.zhang.adapter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Zhang on 11/11/2015 9:33 下午.
 */
public class EnumerationIteratorTest {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");
        Enumeration<String> enumeration = vector.elements();
        EnumerationIterator<String> iterator = new EnumerationIterator<>(enumeration);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
