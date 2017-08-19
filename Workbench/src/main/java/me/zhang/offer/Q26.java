package me.zhang.offer;

import me.zhang.dsa.ComplexListNode;

/**
 * Created by Zhang on 8/19/2017 9:40 AM.
 * <p>
 * 实现函数ComplexListNode clone(ComplexListNode pHead)，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个next指向下一个节点外，还有一个sibling指向链表中的任意节点或者null。
 */
public class Q26 {

    ComplexListNode cloneList(ComplexListNode pHead) {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return disconnectNodes(pHead);
    }

    private void cloneNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            //      Node1 -> Node2 -> Node3
            //        ^
            //      pNode
            ComplexListNode pCloned = new ComplexListNode();
            pCloned.value = pNode.value;
            pCloned.next = pNode.next;
            pCloned.sibling = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
            //      Node1 -> [Node1] -> Node2 -> Node3
            //                            ^
            //                          pNode
        }
    }

    private void connectSiblingNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = pNode.next;
            if (pNode.sibling != null) {
                pCloned.sibling = pNode.sibling.next;
            }
            pNode = pCloned.next;
        }
    }

    private ComplexListNode disconnectNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;

            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.sibling = node2;
        node3.sibling = node2;
        node4.sibling = node4;

        Q26 q26 = new Q26();
        ComplexListNode cloned1 = q26.cloneList(node1);
        ComplexListNode pNode = cloned1;
        System.out.println("Nodes: ");
        while (pNode != null) {
            System.out.println(pNode.value);
            pNode = pNode.next;
        }

        pNode = cloned1;
        System.out.println("Siblings: ");
        while (pNode != null) {
            ComplexListNode sibling = pNode.sibling;
            System.out.println(sibling == null ? "null" : sibling.value);
            pNode = pNode.next;
        }
    }

}
