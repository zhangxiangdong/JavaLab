package me.zhang.offer;

/**
 * Created by Zhang on 8/5/2017 10:44 AM.
 * <p>
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则依次打印出1、2、3一直到最大的3位数即999。
 */
public class Q12 {

    public void print1ToMaxOfNDigitsBad(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (int j = 0; j < number; j++) {
            System.out.println(j);
        }
    }

    public void print1ToMaxOfNDigitsSim(int n) {
        // char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] digits = new char[n];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = '0';
        }
        // 一直自增模拟的大数直至最大数
        while (!increment(digits)) {
            print(digits);
        }
    }

    public void print1ToMaxOfNDigitsRecursively(int n) {
        char[] digits = new char[n];
        printRecursively(digits, 0);
    }

    /**
     * @param index 当前递归方法调用所在字符数组的位置
     */
    private void printRecursively(char[] digits, int index) {
        for (int i = '0'; i <= '9'; i++) {
            digits[index] = (char) i;
            if (index < digits.length - 1) {
                printRecursively(digits, index + 1);
            } else {
                System.out.println(new String(digits));
            }
        }
    }

    /**
     * 模拟累加字符数组表示的大数
     *
     * @param digits 模拟的大数
     * @return 是否加到最大值
     */
    private boolean increment(char[] digits) {
        int takeOver = 0; // 进位标识
        boolean isOverflow = false; // 是否达到最大值标识
        for (int i = digits.length - 1; i >= 0; i--) {
            // 表示相对字符'0'的偏移量
            int offset = digits[i] - '0' + takeOver;
            if (i == digits.length - 1) {
                offset++;
            }

            // i 所在的数字已经加到10，需要进位
            if (offset == 10) {
                if (i == 0) {
                    // 已经加到最大值
                    isOverflow = true;
                } else {
                    takeOver = 1; // 进位
                    // 重置为'0'
                    digits[i] = '0';
                }
            } else {
                digits[i] = (char) ('0' + offset);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 从左边第一个不为0的字符向右按顺序拼接数字字符
     */
    private void print(char[] digits) {
        // 记录从左边数第一个不为0的位置
        int i = 0;
        while (digits[i] == '0') {
            i++;
        }
        // 从左边第一个不为0的位置开始打印
        for (int j = i; j < digits.length; j++) {
            System.out.print(digits[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q12 q12 = new Q12();
        // q12.print1ToMaxOfNDigitsBad(3);

        // q12.print1ToMaxOfNDigitsSim(3);
        q12.print1ToMaxOfNDigitsRecursively(3);
    }

}
