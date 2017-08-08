package me.zhang.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。k从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点的值是为4的节点。
 */
public class Q15 {

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    "} -> ";
        }
    }

    public Node kthNodeFromEnd(Node head1, int k) {
        if (head1 == null) {
            throw new NullPointerException("链表为空。");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("参数k需要大于0。");
        }
        Node head2 = head1;

        int step = 1;
        // head1先移动到正数第k个节点。
        while (step < k) {
            Node n = head1.next;
            if (n == null) {
                throw new IllegalArgumentException("链表长度小于" + k + "。");
            }
            head1 = n;
            step++;
        }

        // 同时向后移动head1，head2。直至head1移动到链表尾部。
        while (head1.next != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        // head2现在指向倒数第k个节点。
        return head2;
    }

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4,
                                        new Node(5,
                                                new Node(6,
                                                        null
                                                )
                                        )
                                )
                        )
                )
        );

        printKthNodeFromEnd(head, 1);
        printKthNodeFromEnd(head, 3);
        printKthNodeFromEnd(head, 6);

        try {
            printKthNodeFromEnd(head, 7);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            printKthNodeFromEnd(null, 3);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

        try {
            printKthNodeFromEnd(head, 0);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void printKthNodeFromEnd(Node head, int k) {
        Q15 q15 = new Q15();
        Node kthNodeFromEnd = q15.kthNodeFromEnd(head, k);
        System.out.println("倒数第" + k + "个节点的值：" + kthNodeFromEnd);
    }

}
