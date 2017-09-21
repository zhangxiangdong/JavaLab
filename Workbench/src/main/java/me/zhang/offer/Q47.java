package me.zhang.offer;

/**
 * Created by zhangxiangdong on 2017/9/21.
 * <p>
 * 不用加减乘除做加法。求两个整数之和，要求在方法体内不能使用加、减、乘、除四则运算符号。
 */
public class Q47 {

    /**
     * 计算两个数的和
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return 两个数的和
     */
    public static int add(int a, int b) {
        int sum, carray;
        do {
            sum = a ^ b;
            carray = (a & b) << 1;

            a = sum;
            b = carray;
        } while (b != 0);
        return sum;
    }

}
