package me.zhang.offer;

import java.util.Stack;

/**
 * Created by Zhang on 8/12/2017 9:47 AM.
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class Q22 {

    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null) {
            throw new NullPointerException();
        }
        if (pushOrder.length != popOrder.length || pushOrder.length == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0; // popOrder下标，标记当前要弹出的数字
        for (int e : pushOrder) {
            stack.push(e);
            // 如果当前栈顶数值和出栈序列当前数值相等，出栈，继续比较下一个出栈序列
            while (!stack.isEmpty() && stack.peek() == popOrder[index]) {
                stack.pop();
                index++;
            }
        }

        // 规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
        // 如果下一个弹出的数字不在栈顶，继续将压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
        // 如果最后所有的数字均已压入栈了，但仍然没找到要弹出的数字，说明输入的序列不是弹出序列。

        // popOrder.length - 1 是弹出序列最后一个元素下标
        return stack.isEmpty() && index > popOrder.length - 1;
    }

}
