package me.zhang.effective.item5;

/**
 * Created by zhangxiangdong on 2017/12/19.
 */
public class AutoboxingTest {

    public static void main(String[] args) {
        fast();
        slow();
    }

    private static void fast() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void slow() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i; // autoboxing
        }
        System.out.println(sum);
    }

}
