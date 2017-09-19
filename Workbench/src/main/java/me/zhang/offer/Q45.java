package me.zhang.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/9/19.
 * <p>
 * 圆圈中最后剩下的数字
 */
public class Q45 {

    /**
     * 0, 1, ..., n - 1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第k个数字。求出这个圆圈里剩下的最后一个数字。
     * 约瑟夫（Josephuse）环问题。
     * 时间复杂度O(nk)，空间复杂度O(n)。
     *
     * @param n 排成一个圆圈的n个数
     * @param k 从0开始要删除的第k个数
     * @return 最后剩下的数字
     */
    public static int lastRemaining(int n, int k) {
        /* 借助集合框架实现 */
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n和k必须大于0");
        }

        // 1. 准备圆圈
        List<Integer> ring = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ring.add(i);
        }
        System.out.println(ring);

        // 2. 第一个要删除的数字的索引
        int removeIndex = k - 1;
        // 3. 一直删除，直到还剩一个数字
        while (ring.size() > 1) {
            // 索引超过剩余的总数，则循环到首部
            removeIndex %= ring.size();

            ring.remove(removeIndex);
            System.out.println(ring);

            // 获取下一个要删除的数字的索引
            removeIndex += k - 1;
        }
        // 4. 返回剩下的最后一个数
        return ring.get(0);
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(1)。
     */
    public static int lastRemaining1(int n, int k) {
        /*
        *
        *           0                       n = 1
        * f(n, k) =
        *           [f(n - 1, k) + m] % n   n > 1
        *
        * 循环方案。
        *
        */
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n和k必须大于0");
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + k) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        int remaining = lastRemaining(5, 3);
        System.out.println("Last Remaining: " + remaining);
        remaining = lastRemaining(1, 1);
        System.out.println("Last Remaining: " + remaining);
        remaining = lastRemaining(1000, 3);
        System.out.println("Last Remaining: " + remaining);

        System.out.println("********************");
        remaining = lastRemaining1(5, 3);
        System.out.println("Last Remaining: " + remaining);
        remaining = lastRemaining1(1, 1);
        System.out.println("Last Remaining: " + remaining);
        remaining = lastRemaining1(1000, 3);
        System.out.println("Last Remaining: " + remaining);
    }

}
