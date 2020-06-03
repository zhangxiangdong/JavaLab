package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶结点所经过的节点形成一条路径。
 */
public class Q25 {

    private int currentSum = 0;

    public void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> path = new Stack<>();
        findPath(root, expectedSum, path);
    }

    private void findPath(BinaryTreeNode root, int expectedSum, Stack<BinaryTreeNode> path) {
        currentSum += root.value;
        path.push(root);

        // 如果是叶结点，并且路径上节点的和等于输入的值，则打印出这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf) {
            System.out.print("A path is found: ");
            for (BinaryTreeNode n : path) {
                System.out.printf("%d -> ", n.value);
            }
            System.out.println();
        }

        // 不是叶结点，遍历子节点
        if (root.left != null) {
            findPath(root.left, expectedSum, path);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, path);
        }

        // 返回父节点前，在路径上删除当前节点，并减去当前节点值
        currentSum -= root.value;
        path.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node12 = new BinaryTreeNode(12, null, null);

        root.left = node5;
        root.right = node12;
        node5.left = node4;
        node5.right = node7;

        Q25 q25 = new Q25();
        q25.findPath(root, 22);
    }

}
