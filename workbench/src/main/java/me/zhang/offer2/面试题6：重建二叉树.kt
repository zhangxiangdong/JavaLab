package me.zhang.offer2

import java.lang.IllegalArgumentException

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 测试用例：
 * ● 普通二叉树（完全二叉树，不完全二叉树）。
 * ● 特殊二叉树（所有结点都没有右子结点的二叉树，所有结点都没有左子结点的二叉树，只有一个结点的二叉树）。
 * ● 特殊输入测试（二叉树的根结点指针为NULL、输入的前序遍历序列和中序遍历序列不匹配）。
 */
object Q6 {

    @JvmStatic
    fun main(args: Array<String>) {
        val preorderList = listOf(1, 2, 4, 7, 3, 5, 6, 8)
        val inorderList = listOf(4, 7, 2, 1, 5, 3, 8, 6)

        val rootNode = TreeBuilder(preorderList, inorderList).buildBinaryTree()
        println(rootNode)

//        val preorderList = listOf(7)
//        val inorderList = listOf(7)
//
//        val rootNode = TreeBuilder(preorderList, inorderList).buildBinaryTree()
//        println(rootNode)
    }

    internal class TreeBuilder(private val preorderList: List<Int>, private val inorderList: List<Int>) {

        fun buildBinaryTree(): TreeNode {
            if (preorderList.size != inorderList.size) {
                throw IllegalArgumentException("Invalid input.")
            }

            return buildBinaryTree0(0, preorderList.size - 1, 0, inorderList.size - 1)
        }

        private fun buildBinaryTree0(
            startPreorder: Int, endPreorder: Int,
            startInorder: Int, endInorder: Int
        ): TreeNode {
            val rootValue = preorderList[startPreorder]

            val rootNode = TreeNode()
            rootNode.value = rootValue

            if (startPreorder == endPreorder) {
                if (startInorder == endInorder
                    && preorderList[startPreorder] == inorderList[startInorder]
                ) {
                    return rootNode
                } else {
                    throw IllegalArgumentException("Invalid input.")
                }
            }

            var rootInorder = startInorder
            while (rootInorder <= endInorder && rootValue != inorderList[rootInorder]) {
                rootInorder++
            }

            if (rootInorder == endInorder && inorderList[rootInorder] != inorderList[endInorder]) {
                throw IllegalArgumentException("Invalid input.")
            }

            val leftLength = rootInorder - startInorder
            val leftPreorderEnd = startPreorder + leftLength

            if (leftLength > 0) {
                rootNode.left = buildBinaryTree0(
                    startPreorder + 1, leftPreorderEnd,
                    startInorder, rootInorder - 1
                )
            }

            if (leftLength < endPreorder - startPreorder) {
                rootNode.right = buildBinaryTree0(
                    leftPreorderEnd + 1, endPreorder,
                    rootInorder + 1, endInorder
                )
            }

            return rootNode
        }

    }

    internal class TreeNode {

        var left: TreeNode? = null
        var value: Int? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return "TreeNode(left=$left, value=$value, right=$right)"
        }

    }

}