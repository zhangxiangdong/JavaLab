package me.zhang.test;

/**
 * Created by Zhang on 2016/3/23 下午 5:44 .
 */
public class ComparableDemo {
    public static void main(String[] args) {
        HDTV tv1 = new HDTV(55, "Samsung");
        HDTV tv2 = new HDTV(60, "Sony");

        if (tv1.compareTo(tv2) > 0) {
            System.out.println(tv1.getBrand() + " is better.");
        } else {
            System.out.println(tv2.getBrand() + " is better.");
        }
    }
}


