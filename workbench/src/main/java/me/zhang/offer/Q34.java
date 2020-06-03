package me.zhang.offer;

/**
 * Created by zhangxiangdong on 2017/8/29.
 * <p>
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 */
public class Q34 {

    /**
     * 获取第n个丑数
     *
     * @param n 第几个
     * @return 丑数
     */
    public int getUglyNumber(int n) {
        int number = 0;
        int uglyNumberIndex = 0;
        while (uglyNumberIndex < n) {
            if (isUgly(++number)) {
                uglyNumberIndex++;
            }
        }
        return number;
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public int getUglyNumberEfficiently(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // 第一个丑数是1
        int nextUglyNumberIndex = 1;
        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;
        while (nextUglyNumberIndex < n) {
            int min = min(uglyNumbers[multiply2Index] * 2,
                    uglyNumbers[multiply3Index] * 3,
                    uglyNumbers[multiply5Index] * 5);
            int nextUglyNumber = (uglyNumbers[nextUglyNumberIndex] = min);

            while (uglyNumbers[multiply2Index] * 2 <= nextUglyNumber) {
                multiply2Index++;
            }
            while (uglyNumbers[multiply3Index] * 3 <= nextUglyNumber) {
                multiply3Index++;
            }
            while (uglyNumbers[multiply5Index] * 5 <= nextUglyNumber) {
                multiply5Index++;
            }

            nextUglyNumberIndex++;
        }
        return uglyNumbers[n - 1];
    }

    private int min(int a, int b, int c) {
        int i = (a < b) ? a : b;
        return i < c ? i : c;
    }

    public static void main(String[] args) {
        Q34 q34 = new Q34();
        final int m = 15;
        int uglyNumber = q34.getUglyNumber(m);
        System.out.println("第" + m + "个丑数是：" + uglyNumber);

        final int n = 1500;
        uglyNumber = q34.getUglyNumberEfficiently(n);
        System.out.println("第" + n + "个丑数是：" + uglyNumber);
    }

}
