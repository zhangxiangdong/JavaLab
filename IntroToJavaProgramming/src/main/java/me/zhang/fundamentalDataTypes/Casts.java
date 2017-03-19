package me.zhang.fundamentalDataTypes;

/**
 * Created by Zhang on 3/19/2017 12:38 PM.
 */
public class Casts {

    public static void main(String[] args) {
        int res = (int) (4.35 * 100);
        System.out.println(res);

        res = (int) Math.round(4.35 * 100);
        System.out.println(res);
    }

}
