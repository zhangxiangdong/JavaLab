package me.zhang.search;

/**
 * Created by Zhang on 7/29/2017 11:06 AM.
 * <p>
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排列。
 * 请完成一个函数，输入这样的二维数组和一个整数，判断数组中是否含有该整数。
 */
public class App {

    public static void main(String[] args) throws IllegalArgumentException {
        int[][] a = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 7;
        boolean result = searchFromTopRight(a, target);
        System.out.printf("\t %b\n", result);

        target = 12;
        result = searchFromLeftBottom(a, target);
        System.out.printf("\t %b\n", result);
    }

    static boolean searchFromTopRight(int[][] a, int target) throws IllegalArgumentException {
        if (a == null || a.length == 0 || a[0].length == 0) {
            throw new IllegalArgumentException("a == null || a.length == 0 || a[0].length == 0");
        }

        final int columns = a[0].length;
        final int rows = a.length;
        boolean found = false;
        int r = 0, c = columns - 1;
        while (r < rows && c >= 0) {
            if (target < a[r][c]) {
                c--;
            } else if (target == a[r][c]) {
                found = true;
                System.out.printf("[%d][%d]\n", r, c);
                break;
            } else {
                r++;
            }
        }
        return found;
    }

    private static boolean searchFromLeftBottom(int[][] a, int target) throws IllegalArgumentException {
        if (a == null || a.length == 0 || a[0].length == 0) {
            throw new IllegalArgumentException("a == null || a.length == 0 || a[0].length == 0");
        }

        final int rows = a.length;
        final int columns = a[0].length;
        boolean found = false;
        int r = rows - 1, c = 0;
        while (r >= 0 && c < columns) {
            if (target > a[r][c]) {
                c++;
            } else if (target == a[r][c]) {
                found = true;
                System.out.printf("[%d][%d]\n", r, c);
                break;
            } else {
                r--;
            }
        }
        return found;
    }

}
