package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

/**
 * Created by Zhang on 8/19/2017 10:43 AM.
 * <p>
 * 输入一个二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q27 {

    BinaryTreeNode convert(BinaryTreeNode pRootOfTree) {
        BinaryTreeNode pHeadOfList = convertNode(pRootOfTree, null);
        while (pHeadOfList != null && pHeadOfList.left != null) {
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private BinaryTreeNode convertNode(BinaryTreeNode pNode, BinaryTreeNode pLastNodeInList) {
        if (pNode == null) {
            return null;
        }

        if (pNode.left != null) {
            pLastNodeInList = convertNode(pNode.left, pLastNodeInList);
        }

        pNode.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pNode;
        }

        pLastNodeInList = pNode;

        if (pNode.right != null) {
            pLastNodeInList = convertNode(pNode.right, pLastNodeInList);
        }

        return pLastNodeInList;
    }

    public static void main(String[] args) {
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;

        Q27 q27 = new Q27();
        BinaryTreeNode pListHead = q27.convert(node8);
        BinaryTreeNode pListNext = pListHead;
        System.out.println("Order: ");
        while (pListNext != null) {
            System.out.printf("%d\t", pListNext.value);
            pListNext = pListNext.right;
        }

        BinaryTreeNode pListPrev = pListHead;
        while (pListPrev.right != null) {
            pListPrev = pListPrev.right;
        }

        System.out.println("\nInverted Order: ");
        while (pListPrev != null) {
            System.out.printf("%d\t", pListPrev.value);
            pListPrev = pListPrev.left;
        }
    }

}
