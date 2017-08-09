package me.zhang.dsa;

public class NodeUtil {

    public static void printOutLinkedList(Node head) {
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

}
