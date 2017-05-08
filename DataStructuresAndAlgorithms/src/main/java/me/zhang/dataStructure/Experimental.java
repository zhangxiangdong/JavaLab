package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/5/8.
 */
public class Experimental {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        repeat1(10000);
        long endTime = System.nanoTime();
        System.out.println("repeat1(), time elapsed -> " + (endTime - startTime) / 1e6 + "ms");

        startTime = System.nanoTime();
        repeat2(10000);
        endTime = System.nanoTime();
        System.out.println("repeat2(), time elapsed -> " + (endTime - startTime) / 1e6 + "ms");

    }

    private static String repeat1(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "*";
        }
        return result;
    }

    private static String repeat2(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("*");
        }
        return result.toString();
    }

}
