package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/9/19.
 * <p>
 * 扑克牌的顺子
 */
public class Q44 {

    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
     * 例如，数组排序后为{0, 1, 3, 4, 5}，在1和3之间空缺了一个2，刚好0可以填补，则该数组形成一个顺子。
     *
     * @param a 随机抽取的5张牌
     * @return 这5张牌是否是顺子
     */
    public static boolean isContinuous(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }

        // 1. 排序数组
        Arrays.sort(a);

        // 2. 统计大小王的张数
        int numOfZero = 0; // 大小王的张数
        int numOfGap = 0; // 排序后相邻两张牌空缺的牌的张数
        int len = a.length;
        for (int i = 0; i < len && a[i] == 0; i++) {
            numOfZero++;
        }

        // 3. 统计排序后相邻两张牌空缺的牌的总张数
        int left = numOfZero; // 相邻的两张牌，左边那张牌的索引
        int right = left + 1; // 相邻的两张牌，右边那张牌的索引
        while (right < len) {
            // 相邻两张牌一样，为对子，不可能是顺子
            if (a[left] == a[right]) {
                return false;
            }

            numOfGap += a[right] - a[left] - 1;
            left = right;
            right++;
        }
        // 4. 大小王的数量是否足以填充空缺，是则为顺子，否则不是顺子
        return numOfGap <= numOfZero;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 0, 5};
        System.out.println(isContinuous(a));
        a = new int[]{1, 4, 3, 0, 8};
        System.out.println(isContinuous(a));
        a = new int[]{2, 1};
        System.out.println(isContinuous(a));
        a = new int[]{1};
        System.out.println(isContinuous(a));
    }

}
