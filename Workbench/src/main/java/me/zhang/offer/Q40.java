package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/9/13.
 * <p>
 * 一个整型数组里除了两个数字外，其他数字都出现了两次。找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 例如，输入数组{2, 4, 3, 6, 3, 2, 5, 5}，因为只有4、6这两个数字出现一次，其他数字都出现了两次，所以输出4和6。
 */
public class Q40 {

    /**
     * 寻找一个只出现一次的数字（其他数字出现多次）。
     *
     * @param a 目标数组。
     * @return 只出现一次的数字。
     */
    public static int appearOnlyOnce(int[] a) {
        validate(a);

        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            // 任何一个数字异或自己都等于0。
            result ^= a[i];
        }
        return result;
    }

    private static void validate(int[] a) {
        if (a == null || a.length == 0) {
            // FIXME: 2017/9/13 只验证是否为空，长度是否大于0。
            throw new IllegalArgumentException();
        }
    }

    /**
     * 找出输入数组中两个只出现一次的数字。
     *
     * @param a 目标数组。
     * @return 两个只出现一次的数字。
     */
    public static int[] twoNumbersAppearOnlyOnce(int[] a) {
        validate(a);

        int temp = a[0];
        for (int i = 1; i < a.length; i++) {
            // 任何一个数字异或自己都等于0。
            temp ^= a[i];
        }
        int indexOf1 = getIndexOf1(temp);
        int num1 = 0, num2 = 0;
        for (int i : a) {
            // 讲数组分成两个部分，分别包含只出现一次的数字。
            if (isBit1(i, indexOf1)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        int[] result = new int[2];
        result[0] = num1;
        result[1] = num2;
        return result;
    }

    /**
     * 找出从最右边开始为1位的位置。
     *
     * @param num 输入数字。
     * @return 1位的位置。
     */
    private static int getIndexOf1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 判断从右边数第index位的位置是否是1位。
     *
     * @param num   输入数字
     * @param index 要判断的位置。
     * @return 是否是1位。
     */
    private static boolean isBit1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 3, 2, 5, 6, 5};
        System.out.println("Appear only once: " + appearOnlyOnce(a));
        a = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println("Two numbers appear only once: " + Arrays.toString(twoNumbersAppearOnlyOnce(a)));
    }

}
