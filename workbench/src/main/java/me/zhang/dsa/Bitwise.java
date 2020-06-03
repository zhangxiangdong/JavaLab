package me.zhang.dsa;

public class Bitwise {

    /**
     * 输入整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001，有2位1。因此如果输入9，该方法返回2。
     *
     * @param num 输入的整数
     * @return 返回的二进制中1位的个数
     */
    int numberOf1(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            // 遇到1位，计数+1
            if ((num & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    int numberOf1Efficiently(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        return count;
    }

}
