package me.zhang.offer;

import me.zhang.dsa.BinaryTreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Zhang on 8/13/2017 9:11 AM.
 * <p>
 * 从上往下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如输入如下的二叉树，则依次打印出8、6、10、5、7、9、11。
 */
/*
            8
          /  \
         6   10
        / \ /  \
       5  7 9  11
 */
public class Q23 {

    private static void breadthFirst(BinaryTreeNode root) {
        if (root == null) {
            throw new NullPointerException();
        }

        Queue<BinaryTreeNode> nodesQueue = new LinkedBlockingQueue<>();
        nodesQueue.add(root);
        while (!nodesQueue.isEmpty()) {
            BinaryTreeNode node = nodesQueue.poll();
            System.out.printf(" %d ", node.value);

            if (node.left != null) {
                nodesQueue.add(node.left);
            }
            if (node.right != null) {
                nodesQueue.add(node.right);
            }
        }
        /*
            规律：每一次打印一个节点的时候，如果该节点有子节点，则把该节点的子节点放到一个队列的末尾。
            接下来取出队列的头节点，重复前面的打印操作，直至队列中所有的节点都被打印出来为止。
         */
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node11 = new BinaryTreeNode(11, null, null);

        root.left = node6;
        root.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;

        breadthFirst(root);
    }

}
