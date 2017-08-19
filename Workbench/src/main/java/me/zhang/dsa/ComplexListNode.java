package me.zhang.dsa;

/**
 * Created by Zhang on 8/19/2017 9:42 AM.
 */
public class ComplexListNode {

    public int value;

    // 指向下一个节点
    public ComplexListNode next;

    // 指向链表中任意节点或者null
    public ComplexListNode sibling;

    public ComplexListNode() {
    }

    public ComplexListNode(int value) {
        this.value = value;
    }

    public ComplexListNode(int value, ComplexListNode next, ComplexListNode sibling) {
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }
}
