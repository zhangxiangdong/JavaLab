package me.zhang.offer;

/**
 * 给定单向链表的头节点和一个节点（位于该链表上），定义一个方法在O(1)时间删除该节点。
 * <p>
 * 以下实现基于假设：要删除的节点位于该链表上。要判断要删除的节点是否位于链表上需要O(n)的时间。
 * 为确保O(1)的删除效率，删除方法未考虑要删除的节点是否在链表上。
 */
public class Q13 {

    public void deleteNode(Node head, Node toBeRemovedNode) {
        if (head == null || toBeRemovedNode == null) {
            return;
        }

        Node nextNode = toBeRemovedNode.next;
        if (nextNode != null) {
            // 要删的节点不在单向链表尾部（头部或者中部）
            toBeRemovedNode.value = nextNode.value;
            toBeRemovedNode.next = nextNode.next;
            nextNode.next = null;
        } else {
            // 要删除的节点是尾节点
            // 遍历链表删除
            if (toBeRemovedNode.value == head.value) {
                // 要删除的节点是头结点（链表只有一个节点）
            } else {
                // 要删的节点位于链表尾部，需要从头遍历链表，删除
                Node n = head;
                while (n.next.value != toBeRemovedNode.value) {
                    n = n.next;
                }
                // n 此时是要删除节点的前一个节点
                // 执行删除操作
                n.next = null;
            }
        }
    }

    public static void main(String[] args) {
        Node toBeDeleted1;
        Node toBeDeleted2;
        Node toBeDeleted3;
        Node head = new Node(
                toBeDeleted1 = new Node(
                        toBeDeleted2 = new Node(
                                toBeDeleted3 = new Node(
                                        null, 3
                                ), 2
                        ), 1
                ), 0);
        System.out.println("Before Deletion: ");
        printOutLinkedList(head);

        Q13 q13 = new Q13();

        System.out.println("\nAfter delete toBeDeleted3: ");
        q13.deleteNode(head, toBeDeleted3);
        printOutLinkedList(head);

        System.out.println("\nAfter delete toBeDeleted1: ");
        q13.deleteNode(head, toBeDeleted1);
        printOutLinkedList(head);

        System.out.println("\nAfter delete toBeDeleted2: ");
        q13.deleteNode(head, toBeDeleted2);
        printOutLinkedList(head);

        // Head is always there, we can't delete it.
        System.out.println("\nAfter delete head: ");
        q13.deleteNode(head, head);
        printOutLinkedList(null);
    }

    private static void printOutLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n);
            n = n.next;
        }
        System.out.println();
    }

    static class Node {
        Node next;
        int value;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    "} -> ";
        }

        Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

}
