package me.zhang.dsa;

import java.util.Stack;

/**
 * Created by Zhang on 7/29/2017 5:26 PM.
 * <p>
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class LinkedList {

    private Node head;

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public Node remove(int value) {
        if (head == null) {
            return null;
        }

        Node removed = head;
        if (head.value == value) {
            head = null;
        } else {
            Node n = head;
            while (n.next != null) {
                if (n.next.value == value) {
                    removed = n.next;
                    n.next = n.next.next;
                    break;
                }
                n = n.next;
            }
        }
        return removed;
    }

    public void printReversely() {
        Stack<Node> nodes = new Stack<>();

        Node n = head;
        while (n != null) {
            nodes.push(n);
            n = n.next;
        }
        while (!nodes.empty()) {
            System.out.print(nodes.peek().value + "\t");
            nodes.pop();
        }
    }

    public Node getHead() {
        return head;
    }

    public void printReverselyRecursively(Node node) {
        Node next = node.next;
        if (next != null) { // Has next node, print it out.
            printReverselyRecursively(next);
        }
        System.out.print(node.value + "\t");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node n = head;
        while (n != null) {
            builder.append(n);
            n = n.next;
        }
        builder.append("null");
        return builder.toString();
    }

    static class Node {

        int value;

        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "] -> ";
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            list.remove(i);
        }
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.remove(5);
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.add(10);
        System.out.println(list);

        list.printReversely();
        list.printReverselyRecursively(list.getHead());
    }

}
