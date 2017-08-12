package me.zhang.offer;

import java.util.Stack;

/**
 * Created by Zhang on 8/12/2017 9:16 AM.
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class Q21 {

    private Stack<Integer> container = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int e) {
        container.push(e);
        if (min.isEmpty() || min.peek() > e) {
            // 最小元素栈为空，或者入栈元素小于最小元素栈栈顶元素
            min.push(e);
        } else {
            // 重复压入最小元素栈栈顶元素
            min.push(min.peek());
        }
    }

    public int pop() {
        min.pop();
        return container.pop();
    }

    public int min() {
        return min.peek();
    }

}
