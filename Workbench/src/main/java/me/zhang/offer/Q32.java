package me.zhang.offer;

/**
 * 输入一个整数n，求从1到n这n个整数中的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1，10，11，12。其中1一共出现了5次。
 */
public class Q32 {

    public int numberOf1Between1AndN(int n) {
        int numberOf1s = 0;
        for (int i = 1; i <= n; i++) {
            numberOf1s += numberOf1(i);
        }
        return numberOf1s;
    }

    private int numberOf1(int number) {
        int numberOf1 = 0;
        while (number != 0) {
            if (number % 10 == 1) {
                numberOf1++;
            }
            number /= 10;
        }
        return numberOf1;
    }

    public static void main(String[] args) {
        Q32 q32 = new Q32();
        int numberOf1s = q32.numberOf1Between1AndN(12);
        System.out.printf("Number of 1 between 1 and %d: %d times", 12, numberOf1s);
    }

}
