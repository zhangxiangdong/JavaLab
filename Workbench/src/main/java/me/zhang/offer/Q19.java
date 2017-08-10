package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

/**
 * 完成一个方法，输入一个二叉树，该方法输入它的镜像。
 */
public class Q19 {

    public static BinaryTreeNode mirrorOf(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return null;
        }

        BinaryTreeNode temp = rootNode.right;
        rootNode.right = rootNode.left;
        rootNode.left = temp;
        mirrorOf(rootNode.left);
        mirrorOf(rootNode.right);

        return rootNode;
    }

    public static void main(String[] args) {
        System.out.println("Tree: ");
        /*
                              10
                            /    \
                           8      7
                          / \    / \
                         6   3  5   9
                        / \      \
                       2   1      4
         */
        BinaryTreeNode root = new BinaryTreeNode(10, null, null);
        BinaryTreeNode treeA1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode treeA2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode treeA3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode treeA4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode treeA5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode treeA6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode treeA7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode treeA8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode treeA9 = new BinaryTreeNode(9, null, null);

        root.left = treeA8;
        root.right = treeA7;

        treeA8.left = treeA6;
        treeA8.right = treeA3;

        treeA6.left = treeA2;
        treeA6.right = treeA1;

        treeA7.left = treeA5;
        treeA7.right = treeA9;

        treeA5.right = treeA4;

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

        System.out.println("Mirror: ");
        /*
                              10
                            /    \
                           7      8
                          / \    / \
                         9   5  3   6
                            /      / \
                           4      1   2
         */
        BinaryTreeNode mirror = mirrorOf(root);
        preorder(mirror);
        System.out.println();
        inorder(mirror);
        System.out.println();
        postorder(mirror);
        System.out.println();
    }

    static void preorder(BinaryTreeNode treeRoot) {
        if (treeRoot == null) {
            return;
        }
        System.out.print(treeRoot);
        preorder(treeRoot.left);
        preorder(treeRoot.right);
    }

    static void inorder(BinaryTreeNode treeRoot) {
        if (treeRoot == null) {
            return;
        }
        inorder(treeRoot.left);
        System.out.print(treeRoot);
        inorder(treeRoot.right);
    }

    static void postorder(BinaryTreeNode treeRoot) {
        if (treeRoot == null) {
            return;
        }
        postorder(treeRoot.left);
        postorder(treeRoot.right);
        System.out.print(treeRoot);
    }


}
