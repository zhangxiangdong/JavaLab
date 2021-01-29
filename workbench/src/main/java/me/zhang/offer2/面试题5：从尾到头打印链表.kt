package me.zhang.offer2

import java.util.*

/**
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 *
 * 测试用例：
 * 1、功能测试（输入的链表有多个结点，输入的链表只有一个结点）。
 * 2、特殊输入测试（输入的链表头结点指针为NULL）。
 */
object Q5 {

    @JvmStatic
    fun main(args: Array<String>) {
        val head = Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
        // 顺序打印链表
        printLinkedList(head)

        println()

        // 逆序打印链表（使用栈）
        printLinkedListReversed0(head)

        println()

        // Print LinkedList Reversed(Recursively)
        printLinkedListReversed1(head)
    }

    /**
     * 基于递归的代码看起来很简洁，但有个问题：当链表非常长的时候，就会导致函数调用的层级很深，从而有可能导致函数调用栈溢出。
     */
    private fun printLinkedListReversed1(head: Node?) { // Superb
        if (head != null) {
            printLinkedListReversed1(head.next)
            print(head.value)
            print("→")
        }
    }

    private fun printLinkedListReversed0(head: Node?) { // Moderate
        val stack = Stack<Int>()
        var currentNode = head
        while (currentNode != null) {
            stack.push(currentNode.value)

            currentNode = currentNode.next
        }

        while (!stack.empty()) {
            print(stack.pop())
            print("→")
        }
    }

    private fun printLinkedList(head: Node?) {
        val builder = StringBuilder()
        var currentNode = head
        while (currentNode != null) {
            builder.append(currentNode.value)
            builder.append("→")

            currentNode = currentNode.next
        }

        print(builder.toString())
    }

    internal class Node(val value: Int?, val next: Node?)

}