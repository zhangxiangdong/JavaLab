package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/22.
 */
public class Powers {

    public double power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public double fasterPower(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = fasterPower(x, n / 2);
            double result = partial * partial;
            if (n % 2 == 1) {
                result *= x;
            }
            return result;
        }
    }

}
