package me.zhang.offer;

import me.zhang.dsa.ResultNotFoundException;

/**
 * Created by zhangxiangdong on 2017/8/29.
 * <p>
 * 在字符串中找出第一个只出现一次的字符。例如输入"abaccdeff"，则输出'b'
 */
public class Q35 {

    /**
     * 依次取出一个字符同剩余的其它字符对比，没有重复的字符，则该字符为要查找的字符。
     * 时间复杂度O(n^2)
     *
     * @param input 输入的字符串
     * @return 第一个只出现一次的字符
     */
    public char findTheFirstCharThatAppearsOnlyOnce(String input) {
        for (int i = 0; i < input.length(); i++) {
            boolean noRepeating = true;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j) && i != j) { // 对比除了自己以外的其他字符
                    noRepeating = false;
                    break;
                }
            }
            if (noRepeating) {
                return input.charAt(i);
            }
        }
        throw new ResultNotFoundException("没有找到第一个只出现一次的字符");
    }

    /**
     * 构建简易的Hash Table，使用字符对应的int型数字作为数组下标。
     * 遍历整个字符数组，将出现的字符对应数组下标的值+1。
     * 找出数组中值为1的索引，即为要查找的字符。
     * 时间复杂度O(n)。
     *
     * @param input 输入字符串
     * @return 第一个只出现一次的字符
     */
    public char findTheFirstCharThatAppearsOnlyOnceEfficiently(String input) {
        int[] table = new int[256];
        for (int i = 0; i < input.length(); i++) {
            table[input.charAt(i)]++;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (table[c] == 1) {
                return c;
            }
        }
        throw new ResultNotFoundException("没有找到第一个只出现一次的字符");
    }

    public static void main(String[] args) {
        Q35 q35 = new Q35();
        System.out.println("第一个只出现一次的字符：");
        System.out.println(q35.findTheFirstCharThatAppearsOnlyOnce("abaccdeff"));
        try {
            System.out.println(q35.findTheFirstCharThatAppearsOnlyOnce("aabbccdd"));
        } catch (ResultNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(q35.findTheFirstCharThatAppearsOnlyOnceEfficiently("faaccdde"));
        try {
            System.out.println(q35.findTheFirstCharThatAppearsOnlyOnceEfficiently("aabbccdd"));
        } catch (ResultNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
