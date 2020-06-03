package me.zhang.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3, 32, 321}，则打印出这3个数字能排成的最小数字321323。
 * <p>
 * 定义两个数m、n大小新规则：若mn > nm 则 m > n；若mn < nm 则 m < n； 若mn == nm 则 m = n。
 */
public class Q33 {

    public void printMinNumber(int[] input) {
        List<Integer> toBeSorted = new ArrayList<Integer>() {
            private static final long serialVersionUID = 3851641709245916439L;

            {
                for (int i : input) add(i);
            }
        };

        // 根据新的大小规则排序
        toBeSorted.sort((m, n) -> {
            String mn = m.toString() + n.toString();
            String nm = n.toString() + m.toString();
            return mn.compareTo(nm);
        });

        // 打印最小排序数
        StringBuilder builder = new StringBuilder();
        for (Integer i : toBeSorted) {
            builder.append(i);
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Q33 q33 = new Q33();
        int[] input = {3, 32, 321};
        q33.printMinNumber(input);
    }

}
