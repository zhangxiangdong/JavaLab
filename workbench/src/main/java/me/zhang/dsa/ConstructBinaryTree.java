package me.zhang.dsa;

/**
 * 输入某二叉树的先序遍历和中序遍历结果，重建出该二叉树。
 */
public class ConstructBinaryTree {

    static class Node {
        int value;
        Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    static void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        Node left = root.left;
        if (left != null) {
            printPreorder(left);
        }
        Node right = root.right;
        if (right != null) {
            printPreorder(right);
        }
    }

    static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        if (left != null) {
            printInorder(left);
        }
        System.out.println(root);
        Node right = root.right;
        if (right != null) {
            printInorder(right);
        }
    }

    static void printPostorder(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        if (left != null) {
            printPostorder(left);
        }
        Node right = root.right;
        if (right != null) {
            printPostorder(right);
        }
        System.out.println(root);
    }

    public static void main(String[] args) {

        // 普通二叉树
        //              1
        //           /     \
        //          2       3
        //         /       / \
        //        4       5   6
        //         \         /
        //          7       8
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println("普通二叉树");
        validate(new Order(preorder, inorder).getTree());

        // 所有结点都没有右子结点
        //            1
        //           /
        //          2
        //         /
        //        3
        //       /
        //      4
        //     /
        //    5
        preorder = new int[]{1, 2, 3, 4, 5};
        inorder = new int[]{5, 4, 3, 2, 1};
        System.out.println("所有结点都没有右子结点");
        validate(new Order(preorder, inorder).getTree());

        // 所有结点都没有左子结点
        //            1
        //             \
        //              2
        //               \
        //                3
        //                 \
        //                  4
        //                   \
        //                    5
        preorder = new int[]{1, 2, 3, 4, 5};
        inorder = new int[]{1, 2, 3, 4, 5};
        System.out.println("所有结点都没有左子结点");
        validate(new Order(preorder, inorder).getTree());

        // 树中只有一个结点
        preorder = new int[]{1};
        inorder = new int[]{1};
        System.out.println("树中只有一个结点");
        validate(new Order(preorder, inorder).getTree());

        // 完全二叉树
        //              1
        //           /     \
        //          2       3
        //         / \     / \
        //        4   5   6   7
        preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        System.out.println("完全二叉树");
        validate(new Order(preorder, inorder).getTree());

        // 输入空指针
        System.out.println("输入空指针");
        try {
            validate(new Order(null, null).getTree());
        } catch (NullPointerException e) {
            System.out.println("*输入空指针*");
        }

        // 输入的两个序列不匹配
        System.out.println("输入的两个序列不匹配");
        preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        inorder = new int[]{4, 2, 8, 1, 6, 3, 7};
        try {
            validate(new Order(preorder, inorder).getTree());
        } catch (IllegalArgumentException e) {
            System.out.println("*输入的两个序列不匹配*");
        }
    }

    static class Order {
        int preorder[];
        int inorder[];

        public Order(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
        }

        Node getTree() {
            return construct(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

    }

    // 验证构建的二叉树（先序，中序和后序遍历）
    static void validate(Node tree) {
        System.out.println("********************");
        printPreorder(tree);
        System.out.println();
        printInorder(tree);
        System.out.println();
        printPostorder(tree);
        System.out.println();
    }

    /**
     * @param preorder      先序遍历
     * @param startPreorder 先序遍历起始位置
     * @param endPreorder   先序遍历结束位置
     * @param inorder       中序遍历
     * @param startInorder  中序遍历起始位置
     * @param endInorder    中序遍历结束位置
     * @return 构建好的二叉树
     * @throws IllegalArgumentException 输入参数有错误
     */
    static Node construct(int[] preorder, int startPreorder, int endPreorder,
                          int[] inorder, int startInorder, int endInorder)
            throws IllegalArgumentException {
        if (preorder == null || inorder == null) {
            throw new NullPointerException();
        }

        // 先序遍历第一个节点值即为根节点的值
        int rootValue = preorder[startPreorder];
        Node root = new Node(rootValue, null, null);

        // 只有一个节点，直接返回
        if (startPreorder == endPreorder) {
            if (startInorder == endInorder
                    && preorder[startPreorder] == inorder[startInorder]) {
                return root;
            }
            throw new IllegalArgumentException();
        }

        // 在中序遍历中找到根节点的位置
        int rootInorder = startInorder;
        while (rootInorder <= endInorder && rootValue != inorder[rootInorder]) {
            rootInorder++;
        }

        if (rootInorder == endInorder && inorder[rootInorder] != rootValue) {
            throw new IllegalArgumentException();
        }

        // 左子树的长度
        int leftLength = rootInorder - startInorder;
        // 找到先序遍历中左子树结束位置
        int leftPreorderEnd = startPreorder + leftLength;
        if (leftLength > 0) { // 含有左子树
            // 构建左子树
            root.left = construct(preorder, startPreorder + 1, leftPreorderEnd,
                    inorder, startInorder, rootInorder - 1);
        }
        if (leftLength < endPreorder - startPreorder) { // 含有右子树
            // 构建右子树
            root.right = construct(preorder, leftPreorderEnd + 1, endPreorder,
                    inorder, rootInorder + 1, endInorder);
        }

        return root;
    }

}
