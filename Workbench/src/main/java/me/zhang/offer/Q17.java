package me.zhang.offer;

import me.zhang.dsa.Node;

import static me.zhang.dsa.NodeUtil.printOutLinkedList;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是按照递增排序的。
 * 例如：1->3->5->7->9和0->2->4->6->8合并后，0->1->2->3->4->5->6->7->8->9。
 */
public class Q17 {

    public static Node merge(Node pHead, Node qHead) {
        if (pHead == null) {
            return qHead;
        } else if (qHead == null) {
            return pHead;
        }

        // 占位节点，用于返回新链表的头部
        Node dummy = new Node();
        // 获取新链表的第一个节点（也是尾节点）
        Node tail = dummy;
        while (true) {
            // 尾节点指向剩余的链表，形成完整的新链表
            if (pHead == null) {
                tail.next = qHead;
                break;
            } else if (qHead == null) {
                tail.next = pHead;
                break;
            }

            // 临时记录两个链表中即将分离的较小的节点
            Node rNode;
            // 记录较小的要分离的节点
            if (pHead.value < qHead.value) {
                rNode = pHead;
                pHead = pHead.next;
            } else {
                rNode = qHead;
                qHead = qHead.next;
            }
            // 将分离出的较小的节点追加到新链表的尾部
            rNode.next = null;
            tail.next = rNode;
            tail = rNode; // 指向新的尾部
        }

        return dummy.next; // 返回新链表的头节点
    }

    public static Node mergeRecursively(Node pHead, Node qHead) {
        if (pHead == null) {
            return qHead;
        } else if (qHead == null) {
            return pHead;
        }

        if (pHead.value < qHead.value) {
            pHead.next = mergeRecursively(pHead.next, qHead);
            return pHead;
        } else {
            qHead.next = mergeRecursively(pHead, qHead.next);
            return qHead;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test1: ");
        test1();
        System.out.println("Test2: ");
        test2();
        System.out.println("Test3: ");
        test3();
        System.out.println("Test4: ");
        test4();
        System.out.println("Test5: ");
        test5();

        System.out.println("*************************");

        System.out.println("Test1Recursively: ");
        test1Recursively();
        System.out.println("Test2Recursively: ");
        test2Recursively();
        System.out.println("Test3Recursively: ");
        test3Recursively();
        System.out.println("Test4Recursively: ");
        test4Recursively();
        System.out.println("Test5Recursively: ");
        test5Recursively();
    }

    private static void test1() {
        Node head1 = new Node(1, null);
        Node next1 = head1;
        for (int i = 3; i <= 9; i += 2) {
            next1.next = new Node(i, null);
            next1 = next1.next;
        }
        printOutLinkedList(head1);

        Node head2 = new Node(0, null);
        Node next2 = head2;
        for (int i = 2; i <= 8; i += 2) {
            next2.next = new Node(i, null);
            next2 = next2.next;
        }
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

    private static void test2() {
        Node head1 = new Node(1, new Node(5, new Node(8, null)));
        printOutLinkedList(head1);
        Node head2 = new Node(2, new Node(3, new Node(4, null)));
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

    private static void test3() {
        Node head1 = null;
        printOutLinkedList(head1);
        Node head2 = new Node(2, new Node(3, new Node(4, null)));
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

    private static void test4() {
        Node head1 = new Node(1, new Node(5, new Node(8, null)));
        printOutLinkedList(head1);
        Node head2 = null;
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

    private static void test5() {
        Node head1 = null;
        printOutLinkedList(head1);
        Node head2 = null;
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

    private static void test1Recursively() {
        Node head1 = new Node(1, null);
        Node next1 = head1;
        for (int i = 3; i <= 9; i += 2) {
            next1.next = new Node(i, null);
            next1 = next1.next;
        }
        printOutLinkedList(head1);

        Node head2 = new Node(0, null);
        Node next2 = head2;
        for (int i = 2; i <= 8; i += 2) {
            next2.next = new Node(i, null);
            next2 = next2.next;
        }
        printOutLinkedList(head2);

        Node n = mergeRecursively(head1, head2);
        printOutLinkedList(n);
    }

    private static void test2Recursively() {
        Node head1 = new Node(1, new Node(5, new Node(8, null)));
        printOutLinkedList(head1);
        Node head2 = new Node(2, new Node(3, new Node(4, null)));
        printOutLinkedList(head2);

        Node n = mergeRecursively(head1, head2);
        printOutLinkedList(n);
    }

    private static void test3Recursively() {
        Node head1 = null;
        printOutLinkedList(head1);
        Node head2 = new Node(2, new Node(3, new Node(4, null)));
        printOutLinkedList(head2);

        Node n = mergeRecursively(head1, head2);
        printOutLinkedList(n);
    }

    private static void test4Recursively() {
        Node head1 = new Node(1, new Node(5, new Node(8, null)));
        printOutLinkedList(head1);
        Node head2 = null;
        printOutLinkedList(head2);

        Node n = mergeRecursively(head1, head2);
        printOutLinkedList(n);
    }

    private static void test5Recursively() {
        Node head1 = null;
        printOutLinkedList(head1);
        Node head2 = null;
        printOutLinkedList(head2);

        Node n = merge(head1, head2);
        printOutLinkedList(n);
    }

}
