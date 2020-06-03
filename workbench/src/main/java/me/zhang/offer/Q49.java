package me.zhang.offer;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by zhangxiangdong on 2017/9/21.
 * <p>
 * 把字符串转换成整数
 */
public class Q49 {

    public static long atoi(String raw) {
        if (raw == null) {
            throw new NullPointerException();
        }
        if (Objects.equals(raw, "")) {
            throw new IllegalArgumentException();
        }

        char[] numbers = raw.toCharArray();
        char first = numbers[0];
        boolean isMinus = false;
        int indexFrom = 0;
        if (first == '+') {
            indexFrom++;
        } else if (first == '-') {
            indexFrom++;
            isMinus = true;
        }
        if (indexFrom >= numbers.length) {
            throw new IllegalArgumentException();
        }
        return atoiCore(Arrays.copyOfRange(numbers, indexFrom, numbers.length), isMinus);
    }

    private static long atoiCore(char[] numbers, boolean isMinus) {
        long number = 0;
        for (char i : numbers) {
            if (i >= '0' && i <= '9') {
                int symbol = isMinus ? -1 : 1;
                number = number * 10 + symbol * (i - '0');
            } else {
                throw new IllegalArgumentException("要转换的字符串包含非数字");
            }
        }
        return number;
    }

}
