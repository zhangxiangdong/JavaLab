package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by Zhang on 8/13/2017 10:22 AM.
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的无重复数字。
 */
/*
    对于二叉搜索树：后序遍历得到的序列中，最后一个数字是树的根节点的值。
    数组中的数字可以分为两部分：第一部分是左子树节点的值，它们都比根节点的值小；
    第二部分是右子树节点的值，它们都比根节点的值大。
 */
public class Q24 {

    public boolean verifyPostorderSequenceOfBinarySearchTree(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int len = sequence.length;
        int root = sequence[len - 1];

        // 二叉搜索树左子树的节点小于根节点的值
        // 获取左右子树分界处（i表示右子树start位置）
        int i = 0;
        while (i < len - 1) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }
        // 在二叉搜索树中右子树的节点值大于根节点
        for (int j = i; j < len - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            // 使用C/C++指针操作，效率更高
            left = verifyPostorderSequenceOfBinarySearchTree(Arrays.copyOfRange(sequence, 0, i));
        }

        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < len - 1) {
            right = verifyPostorderSequenceOfBinarySearchTree(Arrays.copyOfRange(sequence, i, len - 1));
        }

        return left && right;
    }

    public boolean verifyPreorderSequenceOfBinarySearchTree(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int len = sequence.length;
        int root = sequence[0];

        int i = 1;
        while (i < len) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }

        for (int j = i; j < len; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 1) {
            left = verifyPreorderSequenceOfBinarySearchTree(Arrays.copyOfRange(sequence, 1, i));
        }

        boolean right = true;
        if (i < len) {
            right = verifyPreorderSequenceOfBinarySearchTree(Arrays.copyOfRange(sequence, i, len));
        }

        return left && right;
    }

}
