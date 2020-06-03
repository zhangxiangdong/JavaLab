package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

/**
 * Created by zhangxiangdong on 2017/9/13.
 */
public class Q39 {

    // 使用全局变量，获取树深度的同时判断是否是平衡二叉树。
    private static boolean isBalanced = true;

    /**
     * 输入一颗二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * @param root 二叉树的根节点。
     * @return 二叉树的深度。
     */
    public static int depthOfBinaryTree(BinaryTreeNode root) {
        if (root == null) return 0;
        int leftDepth = depthOfBinaryTree(root.left);
        int rightDepth = depthOfBinaryTree(root.right);

        // 左右子树的深度相差超过1，不是平衡二叉树。
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * 输入一个二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任一节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param root 二叉树的根节点。
     * @return 是否是一棵平衡二叉树。
     */
    public static boolean isBalanced(BinaryTreeNode root) {
        if (root == null) return true;
        int leftDepth = depthOfBinaryTree(root.left);
        int rightDepth = depthOfBinaryTree(root.right);
        int diff = leftDepth - rightDepth;
        return diff <= 1 && diff >= -1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        node5.left = node7;

        System.out.println("Tree Depth: " + depthOfBinaryTree(root));
        System.out.println("Is Balanced: " + isBalanced);
        System.out.println("Is Balanced: " + isBalanced(root));
    }

}
