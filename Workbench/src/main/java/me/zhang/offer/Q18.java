package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class Q18 {

    public static boolean hasSubtree(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        boolean result = false;
        if (treeA != null && treeB != null) {
            if (treeA.value == treeB.value) { // 根节点值相等
                result = doesTreeAHasTreeB(treeA, treeB);
            }
            if (!result) { // 根节点值不同，继续遍历比较左子树
                result = hasSubtree(treeA.left, treeB);
            }
            if (!result) {
                result = hasSubtree(treeA.right, treeB);
            }
        }
        return result;
    }

    private static boolean doesTreeAHasTreeB(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        if (treeB == null) { // B结构已遍历完毕，说明与A对应位置的值完全相同
            return true;
        }

        if (treeA == null) { // B结构未遍历完毕，说明B与A对应位置结构不同
            return false;
        }

        if (treeA.value != treeB.value) { // 对应位置节点值不同，直接返回false
            return false;
        }

        // 继续分别比较AB各自的左右子结构
        return doesTreeAHasTreeB(treeA.left, treeB.left) && doesTreeAHasTreeB(treeA.right, treeB.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode treeARoot = new BinaryTreeNode(10, null, null);
        BinaryTreeNode treeA1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode treeA2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode treeA3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode treeA4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode treeA5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode treeA6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode treeA7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode treeA8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode treeA9 = new BinaryTreeNode(9, null, null);

        treeARoot.left = treeA8;
        treeARoot.right = treeA7;

        treeA8.left = treeA6;
        treeA8.right = treeA3;

        treeA6.left = treeA2;
        treeA6.right = treeA1;

        treeA7.left = treeA5;
        treeA7.right = treeA9;

        treeA5.right = treeA4;

        BinaryTreeNode treeBRoot = new BinaryTreeNode(7, null, null);
        BinaryTreeNode treeB5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode treeB9 = new BinaryTreeNode(9, null, null);
        treeBRoot.left = treeB5;
        treeBRoot.right = treeB9;

        System.out.println(hasSubtree(treeARoot, treeBRoot));

        // B树结构不属于A树
        treeBRoot.right = treeB5;
        System.out.println(hasSubtree(treeARoot, treeBRoot));

        // B树只有根节点
        treeBRoot.left = null;
        treeBRoot.right = null;
        System.out.println(hasSubtree(treeARoot, treeBRoot));

        // 输入空指针
        treeBRoot = null;
        System.out.println(hasSubtree(treeARoot, treeBRoot));
    }

}
