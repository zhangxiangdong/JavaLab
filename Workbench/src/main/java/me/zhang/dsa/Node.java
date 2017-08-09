package me.zhang.dsa;

/**
 * Linked list 节点
 */
public class Node {

    public Node next;
    public int value;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                "} -> ";
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

}
