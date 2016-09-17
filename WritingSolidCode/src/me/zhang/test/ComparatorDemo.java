package me.zhang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Zhang on 2016/3/23 下午 5:46 .
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        HDTV tv1 = new HDTV(55, "Samsung");
        HDTV tv2 = new HDTV(60, "Sony");
        HDTV tv3 = new HDTV(42, "Panasonic");

        ArrayList<HDTV> al = new ArrayList<>();
        al.add(tv1);
        al.add(tv2);
        al.add(tv3);

        Collections.sort(al, new SizeComparator());
        for (HDTV a : al) {
            System.out.println(a.getBrand());
        }

        reverseOrder();
    }

    private static void reverseOrder() {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(1);
        al.add(2);
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);

        Comparator<Integer> comparator = Collections.reverseOrder();
        Collections.sort(al, comparator);
        System.out.println(al);
    }
}

class SizeComparator implements Comparator<HDTV> {

    @Override
    public int compare(HDTV tv1, HDTV tv2) {
        int tv1Size = tv1.getSize();
        int tv2Size = tv2.getSize();

        if (tv1Size > tv2Size) {
            return 1;
        } else if (tv1Size < tv2Size) {
            return -1;
        } else {
            return 0;
        }
    }

}
