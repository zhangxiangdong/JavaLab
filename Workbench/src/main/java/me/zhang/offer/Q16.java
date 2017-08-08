package me.zhang.offer;

/**
 * 定义一个方法，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。
 */
public class Q16 {

    public static Node reverseLinkedListCyclically(Node head) {
        Node previous = head;
        if (previous == null) {
            return null;
        }

        Node current = head.next;
        if (current == null) {
            return head;
        }

        previous.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        return previous;
    }

    public static Node reverseLinkedListRecursively(Node head) {
        // head看作是前一结点，head.next是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            // 若为空链或者当前结点在尾结点，则直接返回
            return head;
        }
        // 先反转后续节点head.next
        Node reHead = reverseLinkedListRecursively(head.next);
        // 将当前结点的指针域指向前一结点
        head.next.next = head;
        // 前一结点的指针域令为null
        head.next = null;
        return reHead;
    }

    public static void main(String[] args) {
        testCyclically();
        System.out.println("***********************");
        testRecursively();
    }

    private static void testCyclically() {
        // 链表超过三个节点。
        System.out.println("链表超过三个节点：");
        Node head = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(
                                                new Node(
                                                        null, 6
                                                ), 5
                                        ), 4
                                ), 3
                        ), 2
                ), 1
        );
        printLinkedList(head);
        Node tail = reverseLinkedListCyclically(head);
        printLinkedList(tail);

        // 链表只有三个节点。
        System.out.println("链表只有三个节点：");
        head = new Node(
                new Node(
                        new Node(
                                null, 3
                        ), 2
                ), 1
        );
        printLinkedList(head);
        tail = reverseLinkedListCyclically(head);
        printLinkedList(tail);

        // 链表只有两个节点。
        System.out.println("链表只有两个节点：");
        head = new Node(
                new Node(
                        null, 2
                ), 1
        );
        printLinkedList(head);
        tail = reverseLinkedListCyclically(head);
        printLinkedList(tail);

        // 链表只有一个节点。
        System.out.println("链表只有一个节点：");
        head = new Node(
                null, 1
        );
        printLinkedList(head);
        tail = reverseLinkedListCyclically(head);
        printLinkedList(tail);

        // 链表为空。
        System.out.println("链表为空：");
        head = null;
        printLinkedList(head);
        try {
            tail = reverseLinkedListCyclically(head);
            printLinkedList(tail);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void testRecursively() {
        // 链表超过三个节点。
        System.out.println("链表超过三个节点：");
        Node head = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(
                                                new Node(
                                                        null, 6
                                                ), 5
                                        ), 4
                                ), 3
                        ), 2
                ), 1
        );
        printLinkedList(head);
        Node tail = reverseLinkedListRecursively(head);
        printLinkedList(tail);

        // 链表只有三个节点。
        System.out.println("链表只有三个节点：");
        head = new Node(
                new Node(
                        new Node(
                                null, 3
                        ), 2
                ), 1
        );
        printLinkedList(head);
        tail = reverseLinkedListRecursively(head);
        printLinkedList(tail);

        // 链表只有两个节点。
        System.out.println("链表只有两个节点：");
        head = new Node(
                new Node(
                        null, 2
                ), 1
        );
        printLinkedList(head);
        tail = reverseLinkedListRecursively(head);
        printLinkedList(tail);

        // 链表只有一个节点。
        System.out.println("链表只有一个节点：");
        head = new Node(
                null, 1
        );
        printLinkedList(head);
        tail = reverseLinkedListRecursively(head);
        printLinkedList(tail);

        // 链表为空。
        System.out.println("链表为空：");
        head = null;
        printLinkedList(head);
        try {
            tail = reverseLinkedListRecursively(head);
            printLinkedList(tail);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("null");
        } else {
            Node n = head;
            do {
                System.out.print(n);
                n = n.next;
            } while (n != null);
            System.out.println();
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(Node next, int value) {
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

}
