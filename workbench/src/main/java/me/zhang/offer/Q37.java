package me.zhang.offer;

import me.zhang.dsa.Node;
import me.zhang.dsa.NodeUtil;

/**
 * Created by zhangxiangdong on 2017/9/7.
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Q37 {

    /**
     * 获取两个输入链表的公共节点。
     * 时间复杂度O(m+n)。
     *
     * @param mHead 长度为m的链表
     * @param nHead 长度为n的链表
     * @return 公共节点或者null
     */
    public static Node getIntersectionPoint(Node mHead, Node nHead) {
        if (mHead == null || nHead == null) {
            return null;
        }

        int m = getListLength(mHead);
        int n = getListLength(nHead);

        Node pShort, pLong;
        int delta = m - n;
        int absDelta;
        if (delta > 0) {
            pShort = nHead;
            pLong = mHead;
            absDelta = delta;
        } else {
            pShort = mHead;
            pLong = nHead;
            absDelta = -delta;
        }

        /* 在较长的链表上前进absDelta步 */
        while (absDelta > 0) {
            absDelta--;
            pLong = pLong.next;
        }

        /* 同时前进两个链表，直到找到公共节点或者走完链表（没有公共节点） */
        while (pShort != null && pLong != null && pShort != pLong) {
            pShort = pShort.next;
            pLong = pLong.next;
        }

        return pLong; // pShort == pLong, 可能为null
    }

    private static int getListLength(Node list1) {
        int len = 0;
        Node next = list1;
        while (next != null) {
            len++;
            next = next.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1, null);
        int len = 2;
        Node pList = list1;
        Node intersectionPoint = null;
        while (len < 10) {
            pList.next = new Node(len, null);
            if (len == 5) {
                intersectionPoint = pList.next;
            }
            pList = pList.next;
            len++;
        }

        NodeUtil.printOutLinkedList(list1);

        Node list2 = new Node(70, new Node(60, intersectionPoint));
        NodeUtil.printOutLinkedList(list2);

        // 有公共节点
        Node pInter = getIntersectionPoint(list1, list2);
        System.out.println(pInter);

        // 没有公共节点
        Node list3 = new Node(100, new Node(99, null));
        pInter = getIntersectionPoint(list1, list3);
        System.out.println(pInter);

        // 有为null的链表
        pInter = getIntersectionPoint(list1, null);
        System.out.println(pInter);
    }

}
