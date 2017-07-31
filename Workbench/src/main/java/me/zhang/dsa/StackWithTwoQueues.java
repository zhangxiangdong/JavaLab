package me.zhang.dsa;

public class StackWithTwoQueues<E> {

    private QueueWithTwoStacks<E> alpha = new QueueWithTwoStacks<>();
    private QueueWithTwoStacks<E> beta = new QueueWithTwoStacks<>();

    public void push(E e) {
        if (alpha.empty() && beta.empty()) {
            alpha.appendTail(e);
        } else if (alpha.empty()) {
            beta.appendTail(e);
        } else {
            alpha.appendTail(e);
        }
    }

    public E pop() throws IllegalStateException {
        E top;
        if (!alpha.empty()) {
            while (alpha.size() > 1) {
                beta.appendTail(alpha.deleteHead());
            }
            // 操作后，alpha为空
            top = alpha.deleteHead();
        } else {
            while (beta.size() > 1) {
                alpha.appendTail(beta.deleteHead());
            }
            // 操作后，beta为空
            top = beta.deleteHead();
        }
        if (top == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top;
    }

}
