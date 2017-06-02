package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/2.
 */
public class ArrayStack<E> implements Stack<E> {

    private static final int CAPACITY = 1024;
    private final E[] elements;
    private int t = -1; // Index of top element.

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (size() == elements.length) {
            throw new IllegalStateException("Stack is full.");
        }
        t++;
        elements[t] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = elements[t];
        elements[t] = null;
        t--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return elements[t];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("(");
        for (int i = 0; i < size(); i++) {
            builder.append(i);
            if (i < size() - 1) {
                builder.append(", ");
            }
        }
        builder.append(")");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(0);
        System.out.println(arrayStack);
        arrayStack.push(1);
        System.out.println(arrayStack);
        arrayStack.push(2);
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);

        arrayStack.push(3);
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);
    }

}
