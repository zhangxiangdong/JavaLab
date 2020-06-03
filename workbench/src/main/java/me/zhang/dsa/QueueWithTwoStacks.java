package me.zhang.dsa;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

    private Stack<T> alpha = new Stack<>();
    private Stack<T> beta = new Stack<>();

    public int size() {
        return alpha.size() + beta.size();
    }

    public boolean empty() {
        return alpha.empty() && beta.empty();
    }

    public void appendTail(T e) {
        alpha.push(e);
    }

    public T deleteHead() throws IllegalStateException {
        // beta栈不为空，直接弹出元素
        if (!beta.empty()) {
            return beta.pop();
        }

        // 把alpha栈的元素压入beta栈
        while (!alpha.empty()) {
            beta.push(alpha.pop());
        }

        // alpha和beta栈均为空
        if (beta.empty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return beta.pop();
    }

}
