package me.zhang.offer;

import me.zhang.dsa.ResultNotFoundException;

import java.util.Arrays;

/**
 * Created by Zhang on 8/26/2017 10:55 AM.
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class Q29 {

    public int moreThanHalfNumber(int[] in) {
        Arrays.sort(in);
        int occurrence = 1;
        int len = in.length;
        for (int i = 0; i < len - 1; i++) {
            if (in[i] == in[i + 1]) {
                occurrence++;
            } else {
                if (occurrence > len / 2) {
                    return in[i];
                } else {
                    occurrence = 1;
                }
            }
        }
        throw new ResultNotFoundException("数组中没有出现次数超过数组长度一半的");
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Q29 q29 = new Q29();
        try {
            int result = q29.moreThanHalfNumber(in);
            System.out.println("数组中出现次数超过数组长度一半的数：" + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
